package day21;

import java.util.Scanner;
public class Solution{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String s1=sc.nextLine();
        String s2=sc.nextLine();
        System.out.println(Lcs(s1,s2));
    }
    public static String Lcs(String s1,String s2){
        int len1=s1.length();
        int len2=s2.length();
        StringBuilder sb=new StringBuilder();
        int[][] arr=new int[len1+1][len2+1];
        for(int i=0;i<len1+1;i++){

            for(int j=0;j<len2+1;j++){
                if(i==0||j==0){
                    arr[i][j]=0;
                    continue;
                }
                if(s1.charAt(i-1)==s2.charAt(j-1)){
                    arr[i][j]=arr[i-1][j-1]+1;

                }
                else{
                    arr[i][j]=Math.max(arr[i-1][j],arr[i][j-1]);
                }
            }
        }
        int i=len1;
        int j=len2;
        while(i!=0&&j!=0){
            if(s1.charAt(i-1)==s2.charAt(j-1)){
                sb.append(s1.charAt(i-1));
                i--;
                j--;
            }else{
                if(arr[i-1][j]>arr[i][j-1]){
                    i--;

                }else{
                    j--;
                }
            }


        }
        return sb.length()==0?"-1":sb.reverse().toString();
    }
}