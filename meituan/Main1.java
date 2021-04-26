package Try.meituan;

import java.util.Scanner;
import java.util.*;
public class Main1{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int k=sc.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<arr.length;i++){
            arr[i]=sc.nextInt();
        }
        int count=0;
        for(int i=0;i<arr.length;i++){
            String s=getString(arr[i]);
            String k1=String.valueOf(k);
            for(int j=0;j<s.length();j++){
                for(int z=j+1;z<=s.length();z++){
                    String s1=s.substring(j,z);

                }


            }

            if(s.contains(k1)){
                count++;
            }
        }
        System.out.println(count);

    }
    public static String getString(int a){
        ArrayList<Integer> list=new ArrayList<>();
        for(int i=1;i<a/2;i++){
            if(a%i==0){
                if(!list.contains(i)) list.add(i);
                if(!list.contains(a/i)) list.add(a/i);
            }
        }
        int[] arr=new int[list.size()];
        for(int i=0;i<list.size();i++){
            arr[i]=list.get(i);
        }


        Arrays.sort(arr);
        String s="";
        for(int i:arr){
            s+=i;
        }
        return s;
    }
}
