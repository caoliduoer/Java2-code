package Try.binarySearch;
//二分法找一个数字
public class Solution {
    public int GetNumberOfK(int [] array , int k) {
        int count=0;
        for(int i=0;i<array.length;i++){
            if(array[i]==k){
                count++;
            }
            if(array[i]>k){
                break;
            }
        }
        return count;
    }
    public int GetNumberOfK2(int [] array , int k) {
        int index=Binary(array,k);
        if(index<0) return 0;
        int count=0;
        for(int i=index;i<array.length;i++){
            if(array[i]==k)count++;
        }
        for(int i=index-1;i>=0;i--){
            if(array[i]==k)count++;
        }
        return count;
    }
    public int Binary(int[] arr,int k){
        int start=0;
        int end=arr.length-1;
        int mid=0;
        while(start<end){
            mid=(start+end)/2;
            if(arr[mid]<k){
                start=mid+1;
            }else if(arr[mid]>k){
                end=mid-1;
            }else{
                return mid;
            }
        }
        return mid;
    }
}