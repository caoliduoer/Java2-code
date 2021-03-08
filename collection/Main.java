package Try.collection;

import java.util.*;
import java.util.Scanner;
public class Main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String str=sc.nextLine();
        int num=Integer.parseInt(str);

        for(int i=0;i<num;i++){
            String info=sc.nextLine();
            String[]  a=info.split(" ");
            int[] arr=new int[2];
            arr[0]=Integer.parseInt(a[0]);
            arr[1]=Integer.parseInt(a[1]);
            //TreeMap<Integer,Integer> map=new TreeMap<>();
            ArrayList<Integer> list=new ArrayList<>();
            //TreeMap<con,Integer> map=new TreeMap<>();
            if(arr[0]==1){
                list.add(arr[1]);
            }else{
                for(Integer j:list){
                    if(j==arr[1]){
                        list.remove(j);
                    }
                }

            }


            if(list.size()<=2){
                System.out.println("No");
            }else if(list.size()>=4){
                System.out.println("Yes");
            }else{
                if(list.get(0)+list.get(1)<=list.get(2)||list.get(0)+list.get(2)<=list.get(1)||list.get(2)+list.get(1)<=list.get(0)){
                    System.out.println("No");
                }else {
                    System.out.println("Yes");
                }
            }
        }
    }
}
