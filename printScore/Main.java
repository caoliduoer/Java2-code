package javaScript.printScore;
import java.util.Scanner;
public class Main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int num=sc.nextInt();
        float[] arr=new float[num];
        float sum=0;
        float small=100;
        float high=0;
        for(int i=0;i<num;i++){
            arr[i]=sc.nextFloat();
            sum+=arr[i];
            if(arr[i]>high){
                high=arr[i];
            }
            if(arr[i]<small){
                small=arr[i];
            }
        }
        System.out.printf("%.2f %.2f %.2f",high,small,sum/num);
    }
}
