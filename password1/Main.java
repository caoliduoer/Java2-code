package password;

import java.util.Scanner;
public class Main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()){
            String pw=sc.nextLine();
            if(judge(pw)){
                System.out.println("OK");
            }else{
                System.out.println("NG");
            }
        }
    }
    public static boolean judge(String str){
        boolean a=false;
        boolean b=false;
        boolean c=false;
        boolean d=false;
        boolean e=true;
        if(str.length()>8){
            for(int i=0;i<str.length();i++){
                if(str.charAt(i)>='a'&&str.charAt(i)<='z'){
                    a=true;
                }
                else if(str.charAt(i)>='A'&&str.charAt(i)<='Z'){
                    b=true;
                }
                else if(str.charAt(i)>=48&&str.charAt(i)<=57){
                    c=true;
                }else{
                    d=true;
                }
            }
            for(int i=0;i<str.length()-3;i++){
                for(int j=i+1;j<str.length()-3;j++){
                    if(str.substring(i,i+3).equals(str.substring(j,j+3))){
                        e=false;
                    }
                }
            }

        }
        if((a&&b&&c||a&&b&&d||a&&d&&c||d&&b&&c)&&e){
            return true;
        }
        return false;
    }
}
