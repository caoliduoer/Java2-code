package day19;
import java.util.*;


public class Solution {
    /**
     * longest common substring
     //* @param str1 string字符串 the string
     //* @param str2 string字符串 the string
     * @return string字符串
     */
    public static void main(String[] args) {
        Solution s=new Solution();
        String s1="abc";
        String s2="abcdefg";
        System.out.println(s.LCS(s1,s2));
    }
    public String LCS (String str1, String str2) {
        // write code here
        int max=0;
        int index=0;
        int[][] arr=new int[str2.length()+1][str1.length()+1];
        for(int i=0;i<str2.length();i++){
            for(int j=0;j<str1.length();j++){
                if(str1.charAt(j)==str2.charAt(i)){
                    arr[i+1][j+1]=arr[i][j]+1;
                    if(max<arr[i+1][j+1]){
                        max=arr[i+1][j+1];
                        index=j+1;
                    }
                }
            }

        }
        if(max==0){
            return null;
        }else{
            return str1.substring(index-max,index);
        }
    }
}