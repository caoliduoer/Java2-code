package day12;

import java.util.Arrays;

public class Solution {
    public int MoreThanHalfNum_Solution(int [] array) {
        int len=array.length/2;
        Arrays.sort(array);
        int temp=array[0];
        int count=0;
        for(int i=1;i<array.length;i++){
            if(array[i]==temp){
                count++;
            }else{
                temp=array[i];
                count=0;
            }
            if(count>=len){
                return array[i];
            }
        }
        return array[0];
    }
}
