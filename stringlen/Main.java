package Try.stringlen;

import java.util.*;
public class Main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String str=sc.nextLine();
        StringBuffer len= new StringBuffer("");
        StringBuffer last= new StringBuffer("");
        for(int i=0;i<str.length();i++){

            if(str.charAt(i)<='9'&&str.charAt(i)>='0'){
                len.append(str.charAt(i));
            }
            else{
                if(len.length()>last.length()){
                    last=len;
                }
            }
        }
        System.out.println(last.toString());
    }
}