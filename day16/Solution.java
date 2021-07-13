package day16;

import java.util.Arrays;

public class Solution {

        public String PrintMinNumber(int [] numbers) {
            if(numbers.length==0){
                return "";
            }
            Arrays.sort(numbers);
            StringBuffer s=new StringBuffer(Integer.toString(numbers[0]));
            for(int i=1;i<numbers.length;i++){
                String a=s.toString()+numbers[i];
                String b=numbers[i]+s.toString();
                long c=Long.parseLong(a);
                long d=Long.parseLong(b);
                s=c>d?new StringBuffer(b):new StringBuffer(a);

            }
            return s.toString();
        }

        public static void main(String[] args) {
        int[] arr=new int[]{3334,3,3333332};
        Solution s=new Solution();
        System.out.println(s.PrintMinNumber(arr));
    }
}
