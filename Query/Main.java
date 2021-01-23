package Query;

import java.util.Scanner;
public class Main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()){
            String a=sc.nextLine();
            String[] a1=a.split(" ");
            int n=Integer.parseInt(a1[0]);
            int m=Integer.parseInt(a1[1]);
            String score0=sc.nextLine();
            String[] score1=score0.split(" ");
            int[] score=new int[score1.length];
            for(int i=0;i<score1.length;i++){

                score[i]=Integer.parseInt(score1[i]);
            }

            String[] oprate=new String[m];
            for(int i=0;i<m;i++){
                oprate[i]=sc.nextLine();
            }
            for(int i=0;i<m;i++){
                char c=oprate[i].charAt(0);
                //String[] oprate1=new String[2];
                String[] oprate2=oprate[i].split(" ");
                int a2=Integer.parseInt(oprate2[1]);
                int b2=Integer.parseInt(oprate2[2]);
                int big= Math.max(a2, b2);
                int small= Math.min(a2, b2);
                if(c=='Q'){
                    int max=0;
                    for(int j=small-1;j<big;j++){
                        if(score[j]>max){
                            max=score[j];
                        }
                    }
                    System.out.println(max);
                }
                else{
                    score[a2-1]=b2;
                }
            }
        }
    }
}
