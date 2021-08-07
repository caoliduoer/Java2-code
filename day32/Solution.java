package day32;

import java.util.*;


public class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param //height int整型一维数组 舞蹈员身高的一维数组
     * @return int整型
     */
    public static void main(String[] args) {
        Solution s=new Solution();
        int[] arr=new int[]{4,3,2,1};
        System.out.println(s.TeamNums(arr));
    }
    public int TeamNums (int[] height) {
        // write code here
        int count=0;

        for(int i=0;i<height.length;i++){
            boolean big=false;
            boolean small=false;
            for(int j=i+1;j<height.length;j++){
                if(height[i]>height[j]){
                    big=true;
                }if(height[i]<height[j]){
                    small=true;
                }
                for(int k=j+1;k<height.length;k++){
                    if(big&&height[j]>height[k]){
                        count++;
                    }if(small&&height[j]<height[k]){
                        count++;
                    }
                }
            }
        }
        return count;
    }
}