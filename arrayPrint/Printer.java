package Try.arrayPrint;

import java.util.*;

/*
* 有一个二维数组(n*n),写程序实现从右上角到左下角沿主对角线方向打印。
给定一个二位数组arr及题目中的参数n,请返回结果数组。
测试样例:
*/
public class Printer {
    public int[] arrayPrint(int[][] arr, int n) {
        // write code here
        int[] arr1=new int[n*n];
        ArrayList<Integer> list=new ArrayList<>();
        for(int i=1;i<=n;i++){
            int j=0;
            int k=n-i;
            for(;k<n&&j<n;j++,k++){
                list.add(arr[j][k]);
            }
        }
        for(int i=1;i<n;i++){
            for(int j=i,k=0;j<n&&k<n;j++,k++){
                list.add(arr[j][k]);
            }
        }
        for(int i=0;i<list.size();i++){
            arr1[i]=list.get(i);
        }
        return arr1;
    }
}