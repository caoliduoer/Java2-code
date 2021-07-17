package day18;

public class Solution {
    public int count=0;
    public int InversePairs(int [] array) {

        mergerSort(array,0,array.length-1);
        return count;
    }
    public void mergerSort(int[] array,int start,int end){
        if(start>=end){
            return;
        }
        int mid=(start+end)/2;

        mergerSort( array,start,mid);
        mergerSort(array,mid+1,end);
        merge(array,start,mid,end);
    }
    public void merge(int[] arr,int start,int mid,int end){
        int[] temp=new int[end-start+1];//用来存储排序后的数组
        int k=0,i=start,j=mid+1;
        while(i<=mid&&j<=end){//从区间的头部到中间为一部分的比较；从区间中间件到最后为一部分
            if(arr[i]>arr[j]){//
                temp[k++]=arr[j++];
                count=(count+(mid-i+1))%1000000007;
            }else{
                temp[k++]=arr[i++];
            }
        }
        while(i<=mid){//跳出上一个while循环捡漏
            temp[k++]=arr[i++];
        }
        while(j<=end){//同上解释
            temp[k++]=arr[j++];
        }
        for(int l=0;l<temp.length;l++){
            arr[start+l]=temp[l];//顺序排序后的数组，重新复制给当前数组
        }
    }
}
