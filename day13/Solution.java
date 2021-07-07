package day13;

import java.lang.reflect.Array;
import java.util.*;
public class Solution {
    public int MoreThanHalfNum_Solution(int [] array) {
        ArrayList<Integer> list= new ArrayList<Integer>();
        for(int i=0;i<array.length;i++){
            list.add(array[i]);
        }

        int a=list.get(0);
        int index=0;
        while(list.size()>(array.length/2)&&index+1<list.size()){
            if(a!=list.get(index+1)){
                list.remove(index);
                if(index+1< list.size()){
                    list.remove(index+1);
                }
                else{
                    return list.get(index);
                }
                a=list.get(index);
            }
            else{
                if((index++)<list.size())
                    a=list.get(index);
                else{
                    return list.get(index-1);
                }
            }


        }
        return list.get(0);
    }
    public static void main(String[] args) {
        Solution s=new Solution();
        int[] arr=new int[]{2,2,2,2,2,1,3,4,5};
        s.MoreThanHalfNum_Solution(arr);
    }
}