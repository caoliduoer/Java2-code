package Try.about360;

public class Solution {
    /*
    * 1）整数；
2）非降序；
3）有且仅有一组重复数据。
举例：[1,2,3,5,5,5,5,7,9]
要求：找出重复数据的起始，终止下标
    * */
    public static void main(String[] args){
        int arr[]={1,2,3,5,5,5,5,7,9};
        int start=0;
        int end=0;
        int temp=arr[0];
        boolean flag=true;
        int count=0;

        for(int i=1;i<arr.length;i++){

            if(arr[i]==temp){
                count++;
                if(count==1){
                    start=i-1;
                }

                flag=true;
            }else{

                if(flag==true){
                    end=i-1;
                }
                flag=false;
                temp=arr[i];
            }
        }
        System.out.println(start+" "+end);
    }
}
