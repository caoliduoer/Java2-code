package day6;

public class Solution {
    public boolean VerifySquenceOfBST(int [] sequence) {
        if(sequence.length==0){
            return false;
        }
        return judge( sequence,0,sequence.length);
    }
    public boolean judge(int[] arr,int start,int end){
        if(start>=end){
            return true;
        }
        int root=arr[end-1];
        int index=0;//分界点
        boolean flag=false;
        for(int i=start;i<end;i++){
            if(arr[i]>root&&flag==false){//尾部大于根的值。
                index=i;
                flag=true;
            }
            if(arr[i]<root&&flag==true){
                return false;
            }
        }
        return judge(arr,start,index-1)&&judge(arr,index,end-1);

    }

    public static void main(String[] args) {
        
    }
}