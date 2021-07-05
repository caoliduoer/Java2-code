package day11;

import java.util.*;
public class Solution {
    public int MoreThanHalfNum_Solution(int [] array) {
        int len=array.length/2;
        TreeMap<Integer,Integer> map=new TreeMap<>();
        for(int i=0;i<array.length;i++){
            if(map.get(array[i])==null){
                map.put(array[i],0);
            }else{
                int a=map.get(array[i]);
                map.put(array[i],++a);

            }

        }
        int fi=0;
        for(int i:map.keySet()){
            if(map.get(i)>=len){
                fi= i;
            }
        }
        return fi;
    }

    public static void main(String[] args) {
        Solution s=new Solution();
        int[] arr=new int[]{1,2,3,2,2,2,5,4,2};
        System.out.println(s.MoreThanHalfNum_Solution(arr));
    }
}