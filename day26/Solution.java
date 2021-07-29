package day26;

import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) {
        int[] arr=new int[]{4,5,1,6,2,7,3,8};
        Solution s=new Solution();
        System.out.println(s.GetLeastNumbers_Solution(arr, 4));
    }
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {

        ArrayList<Integer> list=new ArrayList<>();
        if(input.length<k||k<=0||input.length==0){
            return list;
        }
        int[] arr=heapSort(input);

        for(int i=0;i<k;i++){
            list.add(arr[i]);
        }
        return list;
    }
    public int[] heapSort(int[] arr){
        for(int i=arr.length/2-1;i>=0;i--){
            createHeap(arr,0,arr.length);//建堆
        }
        for(int i=arr.length-1;i>=0;i--){
            swap(arr,0,i);
            createHeap(arr,0,i);

        }
        return arr;
    }
    public void createHeap(int[] arr,int len1,int len2){
        int temp=arr[len1];
        for(int k=len1*2+1;k<len2;k++){//从第一个子节点开始
            if(k+1<len2&&arr[k]<arr[k+1]){
                k++;
            }if(arr[k]>temp){
                arr[len1]=arr[k];
                len1=k;
            }else{
                break;
            }
        }
        arr[len1]=temp;
    }
    public void swap(int[] arr,int len1,int len2){
        int temp=arr[len1];
        arr[len1]=arr[len2];
        arr[len2]=temp;
    }
}
