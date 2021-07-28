package alibaba;

import java.util.Scanner;
import java.util.*;
public class Main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int num=sc.nextInt();

        while(num>0){
            num--;
            //ArrayList<Integer> runtime=new ArrayList<>();
            //ArrayList<Integer> addtime=new ArrayList<>();

            int day=sc.nextInt();//天数
            int time=sc.nextInt();//chixv shijian
            int[] arrday=new int[day-1];
            int[] addtime=new int[day-1];
            int temp=time-sc.nextInt();//第一天运行后剩余时间
            if(temp>0){
                for(int i=0;i<day-1;i++){
                    arrday[i]=sc.nextInt();//运行时长
                }
                for(int i=0;i<day-1;i++){
                    addtime[i]=sc.nextInt();//加时长
                }
                boolean flag=false;
                for(int i=0;i<day-1;i++){
                    temp+=addtime[i];
                    temp-=arrday[i];
                    if(temp<=0){
                        System.out.println(i+3);
                        flag=true;
                        break;
                    }
                }
                if(!flag){
                    System.out.println(-1);
                }
            }else{
                System.out.println(1);
            }



        }


    }
}
