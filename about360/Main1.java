package Try.about360;

import java.util.Scanner;
public class Main1{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String str=sc.nextLine();
        if(isReverse(str)){
            System.out.println(0);
        }else{
            System.out.println(1);
        }
    }
    public static boolean isReverse(String str){
        int i=0;
        int j=str.length()-1;
        while(i<j){
            if(str.charAt(i)!=str.charAt(j)){
                return false;
            }
            j--;
            i++;
        }
        return true;
    }

}