package badKeyBoard;

import java.util.*;
public class Main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()){
            char[] str=sc.nextLine().toUpperCase().toCharArray();
            char[] str1=sc.nextLine().toUpperCase().toCharArray();
            //TreeMap<Character,Integer> set=new TreeMap<>();
            String s="";
            int j=0;
            int i=0;
            while(i<str1.length&&j<str.length){
                if(str1[i]==str[j]){
                    j++;
                    i++;
                }else{
                    if(!s.contains(Character.toString(str[j]))){
                        s=s+str[j];//字符串后面可以拼接字符
                    }

                    j++;
                }
            }
            for(int k=j;k<str.length;k++){
                if(!s.contains(Character.toString(str[k]))){
                    s=s+str[k];
                }
            }

            System.out.print(s);

        }
    }
}