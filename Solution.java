package arrayrotate;

public class Solution {
    public static void rotate(int[] nums, int k) {
        int len=nums.length*2;
        int[] arr=new int[len];
        System.arraycopy(nums,0,arr,0,nums.length);
        System.arraycopy(nums,0,arr,nums.length,nums.length);
        int count=0;
        int i=nums.length-k;
        while(count<nums.length){
            System.out.print(arr[i]);
            i++;
            count++;
        }

    }public static void main(String[] args){
        int[] arr={1,2,3,4,5};
        rotate(arr,2);
    }
}
