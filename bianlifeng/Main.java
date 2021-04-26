package Try.bianlifeng;

import java.util.*;
public class Main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String str=sc.nextLine();
        String res=getRes1(str,0);
        System.out.println(res);
    }
    public  static  String s="";
    public  static String s1="";
    public  static String s2="";
    public static String getRes1(String str,int a){
        if(a<0){
            return s;
        }
        for(int i=a;i<str.length();i++){
            if(str.charAt(i)=='{'){
                s1=getRes1(str,i+1);
            }else if(str.charAt(i)<='9'&&str.charAt(i)>='0'){
                for(int j=0;j<Integer.parseInt(str.substring(i,i+1));j++){
                    s+=getRes1(str,i+1);
                }
            }else if(str.charAt(i)=='}'){
                    for(int j=i-1;j>=0;j--){
                        if(str.charAt(j)=='{'){
                            break;
                        }else{
                            s2+=str.charAt(j);
                        }

                    }
            }else{
                return str.charAt(i)+getRes1(str,i+1);
            }
        }
        return s;

    }
}
