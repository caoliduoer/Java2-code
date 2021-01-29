package wrongOrder;

import java.util.Scanner;

/*
* 错排计算没有人中奖的概率
* */
public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()){
            int n=sc.nextInt();
            double n1=count(n);
            double n2=digui(n);
            double f=(n1/n2)*100;
            System.out.printf("%.2f",f);
            System.out.println("%");
        }
    }

    private static double digui(int n) {
        double sum=1;
        while(n>1){
            sum*=n;
            n--;
        }
        return sum;

    }

    private static double count(int n) {
        if(n==1){
            return  0;
        }if(n==2){
            return 1;
        }
        return (n-1)*(count(n-1)+count(n-2));
    }
}
