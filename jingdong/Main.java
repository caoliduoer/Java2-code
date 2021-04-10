package Try.jingdong;

import java.util.Scanner;
public class Main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);

        String str=sc.nextLine();
        int num=Integer.parseInt(str);

        String s="";
        s=sc.nextLine();
        char[][] ch=new char[4][s.length()];
        String last=s;
        for(int k=1;k<num;k++){
            s=sc.nextLine();
            for(int i=0;i<s.length();i++){
                ch[k][i]=s.charAt(i);
            }
        }
        for(int i=0;i<s.length();i++){
            ch[0][i]=last.charAt(i);
        }
        String res="";
        char a='a';
        int count=0;
        int count1=0;
        for(int i=0;i<s.length();i++){
            count=0;
            a=ch[0][i];
            count1 = 0;
            for(int j=0;j<num;j++){

                if(ch[j][i]<='z'&&ch[j][i]>='a'){
                    if(a!=ch[j][i]){
                        count++;
                    }
                    a=ch[j][i];
                }
                if(ch[j][i]=='?'){
                    count1++;
                }
            }
            if(count>0){
                res+='?';
            }else if(count1==num){
                res+='a';
            }
            else{
                res+=a;
            }
        }
        System.out.println(res);

    }
}