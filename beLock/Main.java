package Try.beLock;

import java.util.*;
public class Main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String s1=sc.nextLine();
        String s2=sc.nextLine();
        System.out.println(lock(s1));
        System.out.println(unLock(s2));
    }
    public static  String lock(String str){//加密
        StringBuilder fi= new StringBuilder();
        char[] s1=str.toCharArray();
        for(int i=0;i<s1.length;i++){
            if(s1[i]>=97&&s1[i]<=122){//小写字母
                if(s1[i]=='z'){
                    fi.append('A');
                }else{
                    char ch= (char) (s1[i] - 31);
                    fi.append(ch);//变大写的后一位
                }
            }else if(s1[i]<=90&&s1[i]>=65){//大写字母
                if(s1[i]=='Z'){
                    fi.append('a');
                }else{
                    char ch= (char) (s1[i] + 33);
                    fi.append(ch);
                }
            }else if(s1[i]<=57&&s1[i]>=48){//数字
                if(s1[i]=='9'){
                    fi.append('0');
                }else{
                    char ch= (char) (s1[i] + 1);
                    fi.append(ch);
                }
            }else{
                fi.append(s1[i]);
            }
        }
        return fi.toString();
    }
    public static String unLock(String str){
        StringBuilder s= new StringBuilder();
        char[] s1=str.toCharArray();
        for (char c : s1) {
            if (c >= 65 && c <= 90) {//大写字母b变A
                if (c == 'A') {
                    s.append('z');
                } else {
                    char ch= (char) (c + 31);
                    s.append(ch);
                }
            } else if (c >= 97 && c <= 122) {//小写字母
                if (c == 'a') {
                    s.append('Z');
                } else {
                    char ch= (char) (c - 33);
                    s.append(ch);
                }
            } else if (c >= '0' && c <= '9') {
                if (c == '0') {
                    s.append('9');
                } else {
                    char ch= (char) (c - 1);
                    s.append(ch);
                }
            }else {
                s.append(c);
            }
        }
        return s.toString();
    }

}