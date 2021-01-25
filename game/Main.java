package game;

import java.util.Scanner;
public class Main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()){
            int num=sc.nextInt();
            int score=sc.nextInt();
            int[] able=new int[num];
            for(int i=0;i<num;i++){
                able[i]=sc.nextInt();
            }
            for(int i=0;i<num;i++){
                if(score>=able[i]){
                    score+=able[i];
                }else{
                    score+=maxNum(able[i],score);
                }
            }
            System.out.println(score);
        }


    }
    public static int maxNum(int a,int b){
        //int i=0;
        int max=0;
        for(int i=2;i<=(a>b?b:a);i++){
            if(a%i==0&&b%i==0){
                max=i;
            }
        }
        if(max==0){
            return 1;
        }
        return max;
    }

}
