package org.example.Util;

import org.ansj.domain.Term;
import org.ansj.splitWord.analysis.ToAnalysis;
import org.example.moddel.DocInfo;
import org.example.moddel.Weight;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/*
* 构建索引
* 正排索引：从本地文件数据中读取到java内存（类似数据库保存的数据）
* 倒排索引：构建Map《String，list《信息》》（类似数据库hash索引）
* map键：关键词（分词来做）
* map值-信息：（1）docInfo对象引用或是docInfo的id，
* （2）权重（标题中出现对应关键词的数量*10+正文对应关键词*1）
* ---10和1是可以灵活决定的
* （3）关键字：是否保存，待定
*
* */
public class Index {
    //正排索引
    private static final List<DocInfo>  FORWARDINDEX=new ArrayList<>();
    //倒排索引
    private static final Map<String,List<Weight>> INVERTED_INDEX=new HashMap<>();
    /*
    * 构建正排索引的内容，从本地raw_data.txt读取并保存
    * */
    public static void buildForWardIndex(){
        try {
            FileReader fr=new FileReader(Parser.RAW_DATA);
            BufferedReader br=new BufferedReader(fr);
            int id=0;//行号设置为DocInfo的id
            String line;
            while ((line=br.readLine())!=null){
                if(line.trim().equals("")) continue;
                //一行对应一个DocInfo对象

                DocInfo doc=new DocInfo();
                doc.setId(++id);
                String[] parts=line.split("\3");//每行按照\3间隔符拆分
                doc.setTitle(parts[0]);
                doc.setUrl(parts[1]);
                doc.setContent(parts[2]);
               /* //自己排查问题
                if(parts[0].contains("�")){
                    System.out.println("forward======="+doc.getUrl());
                }
                if(parts[0].contains("�")){
                    System.out.println("forward======="+doc.getUrl());
                }*/
                //添加到正排索引
                FORWARDINDEX.add(doc);
            }
        } catch (IOException e) {
            throw  new RuntimeException(e);//有异常就要往外抛
            //初始化时候，有问题就尽早暴露
            //如标题为：
        }
    }

    /*
    * 构建倒排索引：从java内存中正排索引文档信息来构建
    * */
    public static void buildInvertedIndex(){
        for(DocInfo doc:FORWARDINDEX){
            //一个doc：分别对标题和正文分词，每一个分词生成一个weight对象，需要计算权重
            Map<String,Weight> cache=new HashMap<>();
            List<Term> titleFencis= ToAnalysis.parse(doc.getTitle()).getTerms();

            for(Term titleFenci:titleFencis){//标题分词遍历处理
                /*if(titleFenci.getName().contains("�")){
                    System.out.println("标题分词============"+doc.getUrl());
                }*/
                Weight w=cache.get(titleFenci.getName());//获取了标题分词到键对应的weight
                if(w==null){
                    w=new Weight();
                    w.setDoc(doc);
                    w.setKeyword(titleFenci.getName());
                    cache.put(titleFenci.getName(),w);
                }
                //标题分词，权重+10；
                w.setWeight(w.getWeight()+10);
            }
            //正文分词的逻辑和标题分词逻辑相同
            List<Term> contentFencis=ToAnalysis.parse(doc.getContent()).getTerms();
            for(Term contentFenci:contentFencis){
                /*if(contentFenci.getName().contains("�")){
                    System.out.println("正文分词============"+doc.getUrl());
                }*/
                Weight w=cache.get(contentFenci.getName());
                if(w==null){
                    w= new Weight();
                    w.setDoc(doc);
                    w.setKeyword(contentFenci.getName());
                    cache.put(contentFenci.getName(),w);
                }
                w.setWeight(w.getWeight()+1);
            }
            //把临时保存的map数据（keyWord-weight） 全部保存到倒排索引里
            //遍历
            for(Map.Entry<String,Weight> e :cache.entrySet()){
                String keyword=e.getKey();
                Weight w=e.getValue();
                //更新到倒排索引Map<String,List<Weight>>---->多个文档，同一个关键次，保存在list
                //先在倒排索引中，通过keyword获取已有的值；
                List<Weight> weights=INVERTED_INDEX.get(keyword);
                if(weights==null){//如果拿不到就存放进去
                    weights=new ArrayList<>();

                    INVERTED_INDEX.put(keyword,weights);
                }
                weights.add(w);//倒排中，添加当前文档每个分词对应的weight对象
            }
        }
    }


    public static void main(String[] args) {
        Index.buildForWardIndex();
        //测试正排索引
//        FORWARDINDEX.stream().forEach(System.out::println);
        //根据正排索引构建倒排
        Index.buildInvertedIndex();
        //测试倒排索引内容
        for(Map.Entry<String,List<Weight>> e:INVERTED_INDEX.entrySet()){
            String keyword=e.getKey();
            System.out.print(keyword+": ");
            List<Weight> weights=e.getValue();//不校验weight中的doc对象的，正排索引已经测试过
            weights.stream().
                    map(w->{ //map操作：把list中每一个对应转换为其他对象
                        return "("+w.getDoc().getId()+","+w.getWeight()+")";
                    })
                    //.collect(Collectors.toList())//把list中每一个对应转换为其他对象
            //转哈混玩会变成List
                    .forEach(System.out::print);
            System.out.println();
        }
    }
}
