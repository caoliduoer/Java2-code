package pracetice;

import java.util.Scanner;

public class Dp {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int sum=sc.nextInt();
        int[] num=new int[n];
        for(int i=0;i<n;i++){
            num[i]=sc.nextInt();
        }
        System.out.println(getCount(num, sum));
    }

    private static long getCount(int[] num, int sum) {
        long[][] arr=new long[num.length+1][sum+1];
        for(int i=0;i<=num.length;i++){
            arr[i][0]=1;
        }
        for(int j=1;j<=sum;j++){
            arr[0][j]=0;
        }
        for(int i=1;i<arr.length;i++){
            for(int j=1;j<arr[0].length;j++){
                if(num[i-1]<=j){
                    arr[i][j]=arr[i-1][j]+arr[i-1][j-num[i-1]];
                }
                else{
                    arr[i][j]=arr[i-1][j];
                }
            }
        }
        return arr[num.length][sum];
    }
}
