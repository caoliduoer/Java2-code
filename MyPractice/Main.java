package MyPractice;

import java.util.Scanner;
public class Main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String s1=sc.nextLine();
        int num=Integer.parseInt(s1);
        String s2=sc.nextLine();
        int flag=Integer.parseInt(s2);
        int[] score=new int[num];
        String[] name=new String[num];
        for(int i=0;i<num;i++){
            String mess=sc.nextLine();
            String[] str=mess.split(" ");
            name[i]=str[0];
            score[i]=Integer.parseInt(str[1]);
        }
        for(int i=0;i<num;i++){
            for(int j=0;j<num-i-1;j++){
                if(score[j]>score[j+1]){
                    score[j]^=score[j+1];
                    score[j+1]^=score[j];
                    score[j]^=score[j+1];
                    String temp=name[j];
                    name[j]=name[j+1];
                    name[j+1]=temp;
                }
            }
        }
        if(flag==0){
            for(int i=num-1;i>=0;i--){
                System.out.println(name[i]+" "+score[i]);
            }
        }else{
            for(int i=0;i<num;i++){
                System.out.println(name[i]+" "+score[i]);
            }
        }
    }
}