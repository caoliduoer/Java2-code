package Try.xiecheng;


import java.util.*;
public class Main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int num=Integer.parseInt(sc.nextLine());


        String str=sc.nextLine();
        String[] s=str.split(",");
        String c="";
        for(int i=0;i<s.length;i++){
            c+=s[i];
        }
        String[] s1=c.split("]");
        c="";
        for(int i=0;i<s1.length;i++){
            c+=s1[i];
        }
        String[] s2=c.split(" ");
        c="";
        for(int i=0;i<s2.length;i++){
            c+=s2[i];
        }
       // String[] s2=c.split("[[,]]",2);

        int count=1;
        char temp=c.charAt(3);
        if(c.length()<5){
            System.out.println("1");
        }
        for(int i=6;i<c.length();i+=3){
            if(temp!=c.charAt(i)){
                count++;
            }
            temp=c.charAt(i);
        }
        System.out.println(count+1);

    }
    /*
    5
[[1,3], [2,3], [3,4], [2,4]]
2


    *
    * */
}
