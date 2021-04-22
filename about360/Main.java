package Try.about360;

import java.util.Scanner;
public class Main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String str=sc.nextLine();
        int count=0;
        while(!isRes(str)){
            str=getnew(str);
            count++;
        }
        System.out.println(count);
    }
    public  static boolean isRes(String str){
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)=='a'){
                for(int j=i;j<str.length();j++){
                    if(str.charAt(j)=='b'){
                        return false;
                    }
                }
            }
        }
        return true;
    }
    public static String getnew(String str){
        String res="";

        res=str.replace("ab","bba");
            return res;
        }

}
