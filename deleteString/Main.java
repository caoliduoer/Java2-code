package Try.deleteString;

/*
* 输入两个字符串，从第-字符串中删除第二个字符串中所有的字符。 例如，输入”
They are students. "和"aeiou",则删除之后的第一个字符串变成 Thy r stdnts."
*/
import java.util.*;
public class Main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String s1=sc.nextLine();
        String s2=sc.nextLine();
        //ArrayList<Character> list=new ArrayList<>();

        for(int i=0;i<s1.length();i++){
            boolean flag=true;
            for(int j=0;j<s2.length();j++){
                if(s1.charAt(i)==s2.charAt(j)){
                    flag=false;
                    break;
                }
            }
            if(flag){
                System.out.print(s1.charAt(i));
            }

        }
    }
}