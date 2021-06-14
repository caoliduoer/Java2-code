import java.util.Arrays;

public class JishuOushu {
    public static int[] reOrderArray (int[] array) {
        // write code here
        if(array.length==0) return array;

        int j=0;
        int k=0;
        for(int i=0;i<array.length;i++){
            int temp=array[i];
            if(array[i]%2==0){
                continue;
            }else{//当前位置为奇数
                k=i;
                while(k>j){
                    array[k]=array[k-1];
                    k--;
                }
                array[j]=temp;
                j++;
            }
        }
        return array;
    }

    public static void main(String[] args) {
        int[] arr=new int[]{1,2,3,4,5,6};
        System.out.println(Arrays.toString(reOrderArray(arr)));
    }
}
