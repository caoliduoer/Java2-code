package Try.nm;

/*
* 输入两个整数 n 和 m，从数列1，2，3.......n 中随意取几个数,使其和等于 m ,要求将其中所有的可能组合列出来

 * */
import java.util.*;
public class Main1{
    public static ArrayList<ArrayList<Integer>> res=new ArrayList<>();
    public static ArrayList<Integer> list=new ArrayList<>();

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String str=sc.nextLine();
        String[] s=str.split(" ");
        int n=Integer.parseInt(s[0]);
        int m=Integer.parseInt(s[1]);
        find(1,m,n);
        for(ArrayList<Integer> a:res){
            for(Object o:a){
                System.out.print(o+" ");
            }
            System.out.println();
        }
    }
    public static void find(int i,int m,int n){
        if(m==0){
            res.add(new ArrayList<>(list));

        }else{
            for(int j=i;j<=m&&j<=n;j++){
                list.add(j);
                find(j+1,m-j,n);
                list.remove(list.size()-1);
            }

        }
    }
}