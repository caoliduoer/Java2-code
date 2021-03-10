package pracetice;

import java.util.Scanner;
import java.util.*;
public class Main{
    public static void main(String[] args){
        TreeMap<String,Integer> map=new TreeMap<>();
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()){
            String str=sc.nextLine();
            String[] arr=str.split("//");
            String last=arr[arr.length-1];
            //String[] info=last.split(" ");

            //TreeSet<String> set=new TreeSet<>();
            if(map.get(last)!=null){
                int a=map.get(last);
                map.put(last,++a);
            }else{
                map.put(last,1);
            }
            int[] count=new int[map.size()];
            String[] name=new String[map.size()];
            int i=0;
            for(String s:map.keySet()){
                count[i]=map.get(s);
                String[] s1=s.split(" ");
                if(s1[0].length()>16){
                    name[i]=(s1[0].substring(16)+s1[1]);
                }else{
                    name[i]=s;
                }
                i++;
            }
            for(int j=0;j<name.length;j++){
                for(int k=0;k<name.length-j-1;k++){
                    if(count[k]<count[k+1]){
                        int tmp=count[k];
                        count[k]=count[k+1];
                        count[k+1]=tmp;
                        String a=name[k];
                        name[k]=name[k+1];
                        name[k+1]=a;

                    }
                }
            }

            for(int j=0;j<name.length;j++){
                System.out.println(name[j]+" "+count[j]);
                if(j==7) break;

            }
        }


    }
}