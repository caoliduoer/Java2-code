package day29;

import java.util.Scanner;
public class Main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String s=sc.nextLine();
        String[] s1=s.split(",");
        int[] arr=new int[s1.length];
        for(int i=0;i<arr.length-1;i++){
            arr[i]=Integer.parseInt(s1[i]);

        }
        String[] s2=s1[s1.length-1].split(":");
        arr[arr.length-1]=Integer.parseInt(s2[0]);
        int num=Integer.parseInt(s2[1]);
        int end=num-1;
        int start=0;
        float temp=0;
        float avg0=0;
        float max=Float.MIN_VALUE;
        while(end<arr.length){
            float avg=0;
            float sum=0;
            for(int i=start;i<=end;i++){
                sum+=arr[i];
            }
            avg=sum/num;

            if(start>=1){
                temp=(avg-avg0)/avg0;
            }
            avg0=avg;
            if(temp>max){
                max=temp;
            }
            end++;
            start++;
        }
        System.out.println(String.format("%.2f",max*100)+"%");
    }
}
