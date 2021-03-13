package Try.lengthestsubString;

import java.util.*;
/*
* 最大连续子串
* */

public class Solution {
    /**
     * longest common substring
     * @param str1 string字符串 the string
     * @param str2 string字符串 the string
     * @return string字符串
     */
    public static String LCS (String str1, String str2) {
        char[] s1=str1.toCharArray();
        char[] s2=str2.toCharArray();
        int[][] arr=new int[str1.length()+1][str2.length()+1];
        for(int i=0;i<arr.length;i++){
            arr[i][0]=0;
        }
        for(int i=0;i<arr[0].length;i++){
            arr[0][i]=0;
        }
        for(int i=0;i<s1.length;i++){
            for(int j=0;j<s2.length;j++){
                if(s1[i]==s2[j]){
                    arr[i+1][j+1]=arr[i][j]+1;
                }else{
                    arr[i+1][j+1]=Math.max(arr[i][j+1],arr[i+1][j]);
                }
            }
        }

        String last="";
        StringBuilder s= new StringBuilder();
        int max=0;
        for(int i=1;i<arr.length;i++){
            boolean flag=false;
            for(int j=1;j<arr[0].length;j++){
                if(arr[i][j]>max){
                    flag=true;
                    max=arr[i][j];
                    s.append(s1[i - 1]);
                }
            }
            if(!flag){//发生了断层
                if(last.length()<s.length()){

                    last=s.toString();
                    s=new StringBuilder("");
                }
            }
        }
        return last;
    }
    public static String LCS1 (String str1, String str2) {
        // write code here
        int len1 = str1.length();
        int len2 = str2.length();
        int[][] dp = new int[len1+1][len2+1];
        int end = 0;
        int maxLength = 0;
        for(int i=1; i<=len1; i++){
            for(int j=1; j<=len2; j++){
                if(str1.charAt(i-1)==str2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1]+1;
                }else dp[i][j] = 0;
                if(maxLength < dp[i][j]){
                    end = i;
                    maxLength = dp[i][j];
                }
            }
        }
        return str1.substring(end-maxLength, end);
    }

    public static void main(String[] args) {
        String s1="1AB234568CD";
        String s2="123456EF234568C";
        System.out.println(LCS(s1, s2));
    }
}