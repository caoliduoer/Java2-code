package day29;

import java.util.Scanner;
import java.util.*;
public class Main1{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        ArrayList<Integer> list=new ArrayList<>();
        while(sc.hasNext()){
            list.add(sc.nextInt());
        }
        int[] arr=new int[list.size()];
        ArrayList<Integer> pool=new ArrayList<>();
        for(int i=0;i<list.size();i++){
            if(list.get(i)>0){
                arr[i]=-1;
                pool.add(i);
            }
            else{
                if(list.size()>0){
                    arr[i]=list.get(0)+1;
                }
            }
        }
        System.out.println(arr.toString());
    }
}
//1 2 0 0 2 1