package ball;
//计算球的体积
import java.util.*;
public class Main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()){
            String s=sc.nextLine();
            String[] arr=s.split(" ");
            double[] num=new double[arr.length];
            for(int i=0;i<arr.length;i++){
                num[i]=Double.parseDouble((arr[i]));
            }
            double b=Math.sqrt(Math.pow(num[0]-num[3],2)+Math.pow(num[1]-num[4],2)+Math.pow(num[2]-num[5],2));
            System.out.printf("%.3f ",b);
            System.out.printf("%.3f",(4/3.0)*Math.PI*Math.pow(b,3));
        }

    }
}
