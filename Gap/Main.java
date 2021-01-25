package Gap;

import java.util.Scanner;
public class Main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int num=sc.nextInt();
        int sum=0;
        int[] point=new int[num];
        for(int i=0;i<num;i++){
            point[i]=sc.nextInt();
            sum+=point[i];
        }
        float sum1=0;
        for(int i=0;i<num;i++){
            int score=sc.nextInt();
            if(score>=90){

                sum1+= (float) (4.0*point[i]);
            }else if(score>=85){
                sum1+=3.7*point[i];
            }else if(score>=82){
                sum1+=3.3*point[i];
            }else if(score>=78){
                sum1+=3.0*point[i];
            }else if(score>=75){
                sum1+=2.7*point[i];

            }else if(score>=72){
                sum1+=2.3*point[i];
            }else if(score>=68){
                sum1+=2.0*point[i];
            }else if(score>=64){
                sum1+=1.5*point[i];
            }else if(score>=60) {
                sum1+=1.0*point[i];
            }else{
                sum1+=0.0*point[i];
            }
        }
        float a=sum1/sum;
        System.out.printf("%.2f",a);
    }
}
