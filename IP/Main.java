package IP;
/*
* ip地址转换
* */
import java.util.Scanner;
public class Main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String ip=sc.nextLine();
        String ip10=sc.nextLine();
        getIp10(ip);
        getIp(ip10);
    }
    public static void getIp10(String ip){
        String[] str=ip.split("\\.");
        String binary="";
        for(int i=0;i<str.length;i++){

            String b=Integer.toBinaryString((Integer.parseInt(str[i])));
            if(b.length()<8){
                String zore="";
                for(int j=0;j<8-b.length();j++){
                    zore=zore+"0";
                }
                b=zore+b;
            }
            binary+=b;
        }

        System.out.println(Integer.parseInt(binary,2));
    }
    public static void getIp(String ip){
        int num=Integer.parseInt(ip);
        String binary=Integer.toBinaryString(num);
        if(binary.length()<32){
            String zore="";
            for(int i=0;i<32-binary.length();i++){
                zore+="0";
            }
            binary=zore+binary;
        }
        String ip1="";
        for (int i = 0; i <binary.length()-7 ; i=i+8) {
            String sub=binary.substring(i,i+8);
            int a=Integer.parseInt(sub,2);
            if(i<24){
                System.out.print(a+".");
            }else{
                System.out.print(a);
            }

        }

    }
}
