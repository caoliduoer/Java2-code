package pracetice;

import java.util.Scanner;
public class Charge{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String s1=sc.nextLine();
        String[] price=s1.split(" ");
        String p=price[0];
        String s=price[1];
        getFinal(p,s);
    }
    public static void getFinal(String p,String s){
        String[] p1=p.split("\\.");
        String[] s1=s.split("\\.");
        int[] a=new int[p1.length];
        for(int i=p1.length-1;i>=0;i--){
            if(Integer.parseInt(s1[i])-Integer.parseInt(p1[i])>=0){
                a[i]=Integer.parseInt(s1[i])-Integer.parseInt(p1[i]);
            }else{
                if(i==2){
                    while(Integer.parseInt(s1[i])+29-Integer.parseInt(p1[i])<0){
                        a[i]=Integer.parseInt(s1[i])+29-Integer.parseInt(p1[i]);
                        s1[i-1]=Integer.toString(Integer.parseInt(s1[i-1])-1);
                    }

                   // String v=Integer
                }if(i==1){
                    while(Integer.parseInt(s1[i])+17-Integer.parseInt(p1[i])<0){
                        a[i]=Integer.parseInt(s1[i])+17-Integer.parseInt(p1[i]);
                        s1[i-1]=Integer.toString(Integer.parseInt(s1[i-1])-1);
                    }

                }
            }
        }
        for(int i=0;i<s1.length;i++){
            if(i!=2){
                System.out.print(a[i]+".");
            }
            else{
                System.out.print(a[i]);
            }

        }
    }
}
