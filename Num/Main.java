package Num;

import java.util.Scanner;
public class Main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()){
            String num=sc.nextLine();
            isNum(num);
        }
    }

    public static void isNum(String num){
        int n=Integer.parseInt(num);
        int s=(int)Math.sqrt(n);
        String s1=Integer.toString(s);
        if((num.substring(num.length()-s1.length(),num.length())).equals(s1)){
            System.out.println("Yes!");
        }else{
            System.out.println("No!");
        }
    }
}