package Try;

import java.util.Scanner;
import java.util.*;
public class addReverse{
    //分为两种情况：
    //1本身就是回文串：加字母也可回文
    //2本身不是回文串：找出有几种类型的字母，在每个位置添加一次字母判断是否构成回文，如果可以返回true，每种情况都不可构成回文那就不行
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String str=sc.nextLine();
        boolean flag=isReverse(str);
        if(flag){//本身回文
            System.out.println("YES");
        }else{//本身不回文
            ArrayList<Character> list=new ArrayList<>();
            for(int i=0;i<str.length();i++){
                if(!list.contains(str.charAt(i))){//如果bu包含了这个元素添加
                    list.add(str.charAt(i));
                }
            }
            int in=0;
            for(char c:list){
                for(int i=0;i<str.length();i++){
                    String s=str.substring(0,i)+c+str.substring(i,str.length());
                    if(isReverse(s)){
                        System.out.println("YES");
                        in=1;
                        break;
                    }
                }
            }
            if(in!=1){
                System.out.println("NO");
            }


        }
    }
    public static boolean isReverse(String str){
        int i=0;
        int j=str.length()-1;
        while(i<j){
            if(str.charAt(i)!=str.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}