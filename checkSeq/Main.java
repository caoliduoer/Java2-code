package checkSeq;

import java.util.Scanner;
public class Main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()){
            String str=sc.nextLine();
            int n=str.length();
            char[] ch=new char[n];
            ch=str.toCharArray();
            checkSeq(ch);
        }
    }

    public static void checkSeq(char[] ch){
        for(int i=0;i<ch.length;i++){
            int s=(int)ch[i];
            //String s1=Integer.toString(s);
            String binary=Integer.toBinaryString(s);
            int num=0;
            for(int j=0;j<binary.length();j++){
                if(binary.startsWith("1", i)){
                    num++;
                }
            }
            if(binary.length()!=8){
                if((num&1)!=1){
                    String b="1";
                    for(int j=0;j<8-binary.length()-1;j++){
                        b=b+"0";
                    }
                    binary=b+binary;
                }else{
                        String b="";
                        for(int j=0;j<8-binary.length();j++){
                            b=b+"0";
                        }
                        binary=b+binary;

                }
                System.out.println(binary);


            }else{
                System.out.println(binary);

            }

        }

    }
}
