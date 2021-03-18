package Try.nm;


import java.util.Scanner;
import java.util.*;
public class Main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String s=sc.nextLine();
        String[] str =s.split(" ");
        int n=Integer.parseInt(str[0]);
        int m=Integer.parseInt(str[1]);
        ArrayList<ArrayList<Integer>> endlist=new ArrayList<>();
        ArrayList<Integer> list=new ArrayList<>();

        for(int i=1;i<=n/2+1;i++){
            int tar=m;
            list.add(i);
            int j=i;
            tar-=j;

            while(tar>0){

                if(tar<=n){//把单独成为内容的放进去

                    if(!list.contains(j))list.add(j);
                    if(!list.contains(tar))list.add(tar);
                    if(!endlist.contains(list)){
                        endlist.add(new ArrayList<>(list));
                    }
                    list.clear();
                    break;
                }
                j++;
                tar-=j;
            }
            if(tar==0){
                list.add(i-1);
                endlist.add(new ArrayList<>(list));
                tar=m;
                list.clear();
            }
        }
        if(m<=n){
            list.add(m);
            endlist.add(list);
        }
        for(ArrayList<Integer> a:endlist){
            for(Object i:a){
                System.out.print(i+" ");
            }
            System.out.println();
        }
    }
}