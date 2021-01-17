package javaScript.isOrdered;

import java.util.Scanner;
public class Main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int temp=0;
        int count=0;
        int count1=0;
        while(sc.hasNext()){
            int num=sc.nextInt();
            if(temp<num){
                temp=num;
                count1++;
            }else{
                temp=num;
                count++;
            }
        }
        if(count1==n-1||count==n-1){
            System.out.println("sorted");
        }else{
            System.out.println("unsorted");
        }

    }
}
