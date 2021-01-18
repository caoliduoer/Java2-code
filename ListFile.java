package IO1;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
/*
* 打印相应目录下的文件
* */
public class ListFile {
    public static void main(String[] args) {
        File dir=new File("F:\\JavaStudy\\学习课件\\面试总结");
        List<File> files=listDir1(dir);
        //jdk1.8集合框架使用stream操作，可以使用喇叭吗表达式
        files.stream().forEach(System.out::println);
    }

    public static List<File> listDir(File dir){
        List<File> list=new ArrayList<>();//这里效率不高
        if(dir.isFile()){
            list.add(dir);
        }else if(dir.isDirectory()){
            //是文件夹
            File[]  children=dir.listFiles();
            if(children!=null){
                for(File chile:children){
                    List<File> list1=listDir(chile);
                    list.addAll(list1);
                }
            }
        }
        return  list;
    }
    public static List<File> listDir1(File dir){
        List<File> list=new ArrayList<>();
        if(dir.isDirectory()){//如果是文件夹
            //获取目录下一级的子文件和子文件夹
            File[] child=dir.listFiles();
            if(child!=null){
                for(File ch:child){
                    //返回的不包含文件夹
                    if(ch.isDirectory()){//如果是子文件夹，递归调用
                        list.addAll(listDir1(ch));
                    }
                    else{
                        list.add(ch);
                    }
                }
            }
        }
        return  list;
    }
}
