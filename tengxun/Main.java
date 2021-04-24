package Try.tengxun;

import java.util.*;
import java.util.*;
public class Main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int num=sc.nextInt();
        for(int i=0;i<num;i++){
            int len=sc.nextInt();
            int[] arr=new int[len];

            for(int j=0;j<len;j++ ){
                arr[j]=sc.nextInt();
            }
            int[] res=getSort(arr);
            int count=1;
            int temp=0;
            TreeMap<Integer,Integer> map=new TreeMap<>();
            for(int j=0;j<res.length;j++){
                if(map.get(res[j])!=null){
                    int a=map.get(res[j]);
                    map.put(res[j],++a);
                }
                else{
                    map.put(res[j],1);
                }
            }
            boolean flag=false;
            for(int m:map.keySet()){
                if(map.get(m)==1){
                    System.out.println(m);
                    flag=true;
                    break;
                }
            }
            if(!flag){
                System.out.println(-1);
            }

        }
    }
    public static int[] getSort(int[] arr){
        for(int i=0;i<arr.length;i++){
            for(int j=i;j<arr.length-i-1;j++){
                if(arr[j]>arr[j+1]){
                    int temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                }
            }
        }
        return arr;
    }
}/*
1
3
6 9 6
*/