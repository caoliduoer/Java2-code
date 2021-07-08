package day14;

import java.util.*;
public class Solution {
    public int MoreThanHalfNum_Solution(int [] array) {
        int start=0;

        ArrayList<Integer> list=new ArrayList<>();
        for(int i=0;i<array.length;i++){
            list.add(array[i]);
        }
        int end=list.size()-1;
        while(list.size()>0&&end<list.size()&&start<end){
            if(!list.get(start).equals(list.get(end))){
                list.remove(start);
                list.remove(--end);
                end=end-1;


            }else{
                end--;
                start++;
            }

        }
        return list.get(0);
    }

    public static void main(String[] args) {
        Solution s=new Solution();
        int[] arr=new int[]{1,3,4,5,2,2,2,2,2};
        s.MoreThanHalfNum_Solution(arr);
    }
}