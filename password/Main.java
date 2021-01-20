package javaScript.password;
// write your code here
import java.util.Scanner;
public class Main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()){
            String str=sc.nextLine();
            char[] ch=str.toCharArray();
            for(int i=0;i<ch.length;i++){
                if(ch[i]==' '){
                    System.out.print(ch[i]);
                }else if(ch[i]<=90&&ch[i]>=70){
                    System.out.print((char)(ch[i]-5));
                }else{
                    System.out.print((char)(ch[i]+21));
                }
            }
            System.out.println();
        }
    }
}
