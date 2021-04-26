package Try.meituan;

import java.util.Scanner;
public class Main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String str=sc.nextLine();
        String s="";
        int count=1;
        for(int i=0;i<str.length();i++){
            s=str.substring(i,i+1);
            count++;
            for(int j=i+1;j<str.length();j++){
                if(s.indexOf(str.charAt(j))<0){
                    s=s+str.charAt(j);
                    count++;
                }
                else{
                    continue;
                }
            }
        }
        System.out.println(count);
    }
}