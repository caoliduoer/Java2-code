package sort;

import java.util.Scanner;
public class Main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()){
            String  n1=sc.nextLine();
            int n=Integer.parseInt(n1);
            String[] str=new String[n];
            for(int i=0;i<n;i++){
                str[i]=sc.nextLine();

            }
            sortNum(str);
        }
    }
    public static
    void sortNum(String[] s){
        for(int i=0;i<s.length;i++){
            for(int j=0;j<s.length-i-1;j++){
                if(s[j].length()>s[j+1].length()){
                    String tem=s[j];
                    s[j]=s[j+1];
                    s[j+1]=tem;
                }else if(s[j].length()==s[j+1].length()){
                    int check=0;
                    for(int k=0;k<s[j].length();k++){
                        if(s[j].charAt(k)==s[j+1].charAt(k)){
                            continue;
                        }else{
                            check=s[j].charAt(k)>s[j+1].charAt(k)?1:2;
                            break;
                        }
                    }
                    if(check==1){
                        String tem=s[j];
                        s[j]=s[j+1];
                        s[j+1]=tem;
                    }
                }
            }
        }
        for( String s1:s){
            System.out.println(s1);
        }
    }
}
