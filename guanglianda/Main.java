package Try.guanglianda;

import java.util.Scanner;
import java.util.*;
public class Main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String str=sc.nextLine();
        ArrayList<Integer> list1=new ArrayList<>();
        ArrayList<Character> list2=new ArrayList<>();
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)>'z'||str.charAt(i)<'a'){
                continue;
            }
            int count=0;

            for(char c:list2){

                if(str.charAt(i)!=c){
                    count++;
                }

            }
            if(count==list2.size()){
                list1.add(i);
                list2.add(str.charAt(i));
            }

        }
        System.out.println(list1.size());
    }
}