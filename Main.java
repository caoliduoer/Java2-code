package org.example.model;

import java.util.*;
public class Main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        findMin(arr);
    }
    public static void findMin(int[] arr){
        for(int i=0;i<arr.length;i++){
            int a=arr[i];
            int j=0;
            for(j=i-1;j>=0;j--){
                if(arr[j]<a){
                    System.out.print(j);
                    break;
                }
            }
            if(j<0){
                System.out.print(-1);
            }
            int k=0;
            for(k=i+1;k<arr.length;k++){
                if(arr[k]<a){
                    System.out.print(" "+k);
                    break;
                }
            }if(k==arr.length){
                System.out.print(" "+"-1");
            }
            System.out.println();
        }

    }
}
