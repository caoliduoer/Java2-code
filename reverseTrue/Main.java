package Try.reverseTrue;

/*将一个英文语句以单词为单位逆序排放。例如"I am a boy",逆序排放后为
"boy a am I”
所有单词之间用一一个空格隔开，语句中除了英文字母外，不再包含其他字符
*/
import java.util.Scanner;
public class Main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String str=sc.nextLine();
        String s1=reverse(str);
        String[] s2=s1.split(" ");
        for(int i=0;i<s2.length;i++){
            if(i==str.length()-1){
                System.out.println(reverse(s2[i]));
            }else{
                System.out.print(reverse(s2[i])+" ");
            }


        }
    }
    public static String reverse(String str){
        StringBuilder s=new StringBuilder("");
        for(int i=str.length()-1;i>=0;i--){
            s.append(str.charAt(i));
        }
        return s.toString();
    }
}