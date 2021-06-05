import java.util.Scanner;

public class Shangsanjiaojvzhen {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[][] arr=new int[n][n];
        boolean flag=true;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                arr[i][j]=sc.nextInt();

            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<i;j++){
                if(arr[i][j]!=0){
                    flag=false;
                }
            }
        }
        if(flag){//true
            System.out.println("YES");
        }else{
            System.out.println("NO");
        }
    }
}
