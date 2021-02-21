package move;

public class Solution {
    public void reOrderArray(int [] array) {
        int i=0;
        for( i=0;i<array.length;i++){
            if((array[i]&1)==0){
                for(int j=i+1;j<array.length;j++){
                    if((array[j]&1)==1){
                        remove(array,i,j);//插入到i位置
                        break;
                    }
                }
            }
        }

    }
    public void remove(int[] arr,int i,int j){
        int temp=arr[i];
        arr[i]=arr[j];
        for(int k=j;k>i+1;k--){
            arr[k]=arr[k-1];
        }
        arr[i+1]=temp;
    }

    public static void main(String[] args) {
        
    }
}