package org.example.Util;


import org.example.moddel.DocInfo;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/*
* 步骤一：
* 从本地Api目录，遍历静态HTML文件
* 每一个HTML需要构建正文索引：本地某个文件
* 正文索引信息list<DocInfo>
    DocInfo<id,title,content,url>
* */
public class Parser {
    //api目录
    public static final String API_PATH="F:\\search\\docs\\api";
    //构建的本地文件正牌索引
    public static final String RAW_DATA="F:\\search\\raw_data\\raw_data.txt";

    //官方的api文档的根路径
    public static final String API_BASE_PATH="https://docs.oracle.com/javase/8/docs/api";

    public static void main(String[] args) throws IOException {

        //找到api本地路径下所有的HTML文件
        List<File> htmls=listHtml(new File(API_PATH));
        FileWriter fw= new FileWriter(RAW_DATA);
        //BufferedWriter bw=new BufferedWriter(fw);
        PrintWriter pw=new PrintWriter(fw,true);//自动刷新缓冲区


        // List<DocInfo> docs=new ArrayList<>();
       //自行测试
        /* for(File html:htmls){
            System.out.println(html.getAbsolutePath());
        }*/
        for(File html:htmls){
            //一个HTML解析DocInfo所有属性，
            DocInfo doc=parseHtml(html);
            //System.out.println(doc);
           // docs.add(doc);
            //保存本地正排索引文件
            //格式：一个行为一个doc,title+\3+url+\3+content
            String url= html.getAbsolutePath().substring(API_PATH.length());
            System.out.println("Parse"+url);
            pw.println(doc.getTitle()+"\3"+doc.getUrl()+"\3"+doc.getContent());
        }
       /* DocInfo d=docs.get(0);
        System.out.println(d.getContent());*/
        /*for(DocInfo d:docs){
            System.out.println(d.getUrl());
        }
        for(DocInfo d:docs){
            System.out.println(d.getTitle());
        }*/
        //保存本地正排索引文件
    }

    private static DocInfo parseHtml(File html) {
        //一个HTML文件生成Docinfo对象
        DocInfo doc=new DocInfo();
        doc.setTitle(html.getName().substring(0,html.getName().length()-".html".length()));//也可以直接减5
        //获得相对路径
        String url= html.getAbsolutePath().substring(API_PATH.length());
        doc.setUrl(API_BASE_PATH+url);//官方地址绝对路径
        doc.setContent(parseContent(html));//设置正文
        return doc;//目前是从本地api目录的HTML文件解析为文档对象，这个不需要设置id
    }
    //解析HTML文档内容：
    /*
     *<标签>内容<标签>
     *只取内容：有多个标签就拼接
     * */
    private static String parseContent(File html) {
        StringBuilder sb=new StringBuilder();
        try {
            FileReader fr=new FileReader(html);
            int i;
            boolean isContent=false;
            //一个字符一个字符来读取
            while((i=fr.read())!=-1){
                char c=(char)i;
                //根据读取的字符c'<','>',isContent决定了是否拼接字符，continue

                if(isContent){
                    if(c=='<'){//当前标签内容读取结束
                        isContent=false;;
                        continue;
                    } else if (c == '\r'||c=='\n') {//如果是换行符/r/n

                        sb.append(" ");
                    }else{
                        sb.append(c);//拼接标签内容
                    }

                }else if(c=='>'){//当前不是正文，并且读取到>，之后就是正文。
                    isContent=true;
                }

            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return sb.toString();
    }

    //递归遍历HTML文件
    private static List<File> listHtml(File dir){
        List<File> list=new ArrayList<>();
        File[] children=dir.listFiles();//获得子文件和子文件夹
        for(File child:children){
            if(child.isDirectory()){//如果file是文件夹
                list.addAll(listHtml(child));
            }else if(child.getName().endsWith(".html")){//是否是HTML文件
                list.add(child);
            }
        }
        return list;
    }
}

