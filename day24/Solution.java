package day24;

public class Solution {
    public int[] MySort1 (int[] arr) {
        // write code here
        quikSort(arr,0,arr.length-1);
        return arr;
    }
    public void quikSort(int[] arr,int start,int end){
        if(end>start){
            int key=partition(arr,start,end);
            quikSort(arr,start,key-1);
            quikSort(arr,key+1,end);
        }


    }
    public int partition(int[] arr,int start,int end){
        int head=start;
        int tail=end;
        int key=arr[start];
        while(head<tail){
            while (head<tail&&arr[tail]>=key){
                tail--;
            }
            swap(arr,head,tail);
            while (head<tail&&arr[head]<=key){
                head++;
            }

            swap(arr,head,tail);
        }

        return head;
    }
    public  void swap(int[] arr,int i,int j){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
}
