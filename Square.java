package mapractice;

import java.util.Scanner;
public class Square{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String str=sc.nextLine();
        String[] info=str.split(" ");
        int rom=Integer.parseInt(info[0]);
        for(int i=0;i<Math.round(rom/2.0);i++){
            for(int j=0;j<rom;j++){
                if(i==0||i==Math.round(rom/2.0)-1){
                    System.out.print(info[1]);
                }
                else{
                    if(j==0||j==rom-1){
                        System.out.print(info[1]);
                    }else{
                        System.out.print(" ");
                    }
                }
            }
            System.out.println();
        }
    }
}
