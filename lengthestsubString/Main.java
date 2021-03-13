package Try.lengthestsubString;

//最长公共子串
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String s1="abcdefghi";
        String s2="bcdkjilfefghi";
        String max="";

        for(int i=0;i<s1.length();i++){
            StringBuilder now= new StringBuilder();
            int k=i;
            for (int j=0;j<s2.length()&&k<s1.length();j++){
                if(s1.charAt(k)==s2.charAt(j)){
                    now.append(s2.charAt(j));
                    k++;
                }else{
                    if(now.length()>max.length()){
                        max=now.toString();
                    }
                    k=i;

                }
            }
            if(now.length()>max.length()){
                max=now.toString();
            }
        }
        System.out.println(max);
    }
    public String LCS (String str1, String str2) {
        String max="";
        // write code here
        for(int i=0;i<str1.length();i++){
            int k=i;
            StringBuffer sb=new StringBuffer();
            for(int j=0;j<str2.length();j++){

                if(str1.charAt(k)==str2.charAt(j)){
                    sb.append(str2.charAt(j));
                }else{
                    if(max.length()<sb.length()){
                        max=sb.toString();
                        k=i;
                    }
                }
            }
            if(max.length()<sb.length()){
                max=sb.toString();
            }
        }
        return max;
    }
}
