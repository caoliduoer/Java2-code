package practice;

import javax.swing.plaf.nimbus.State;
import java.util.Stack;

public class pailiezuhe {
    public static Stack<Integer> stack=new Stack<>();
    public static void main(String[] args) {
        int[] arr=new int[]{1,2,3,4};
        getStack1(arr,4,0);
        getNum(arr,3,0,0);
    }

    private static void getStack(int[] arr, int i, int i1) {
        if(i==i1){
            System.out.println(stack);
            return;
        }

        for (int value : arr) {
            if (!stack.contains(value)) {
                stack.push(value);
                getStack(arr, i, i1 + 1);
                stack.remove(stack.size() - 1);
            }
        }
    }
    private  static void getStack1(int[] arr,int i,int j){
        if(i==j){
            System.out.println(stack);
            return;
        }
        for(int k=0;k<arr.length;k++){
            if(!stack.contains(arr[k])){
                stack.push(arr[k]);
                getStack1(arr,i,j+1);
                stack.remove(stack.size()-1);
            }
        }
    }
    private static  void getNum(int[] arr,int tar,int i,int j){
        if(i==tar){
            System.out.println(stack);
            return ;
        }
        boolean[] flag=new boolean[arr.length];
        for(int k=i;k<arr.length;k++){
            if(!stack.contains(arr[k])){
                stack.push(arr[k]);
               // flag[i]=true;
                getNum(arr,tar,i+1,k);
                stack.pop();

            }
        }
    }
}
