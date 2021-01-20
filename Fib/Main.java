package javaScript.Fib;

import java.util.Scanner;
public class Main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int mouth=sc.nextInt();
        System.out.println(getTotal1(mouth));
    }
    public static int getTotal(int mon){
        if(mon==1||mon==2){
            return 1;
        }else{
            return getTotal(mon-1)+getTotal(mon-2);
        }
    }
    public static int getTotal1(int mon){
        int sum=0;
        int one=1;
        int two=1;
        if(mon==1||mon==2){
            return 1;
        }
        for(int i=2;i<mon;i++){
            sum=one+two;
            one=two;
            two=sum;
        }
        return sum;
    }
}