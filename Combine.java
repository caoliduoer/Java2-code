import java.util.Scanner;

public class Combine {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        int[] arr1=new int[n];
        int[] arr2=new int[m];
        for(int i=0;i<n;i++){
            arr1[i]=sc.nextInt();
        }
        for(int i=0;i<m;i++){
            arr2[i]=sc.nextInt();
        }
        int[] arr=new int[n+m];
        int i=0;
        int j=0;
        int k=0;
        while(i!=n&&j!=m){
            if(arr1[i]>=arr2[j]){
                arr[k]=arr2[j];
                k++;
                j++;
            }
            else{
                arr[k]=arr1[i];
                i++;
                k++;
            }
        }
        if(i==n){
            for(int l=k;l<(m+n);l++){
                arr[l]=arr2[j];
                j++;
            }
        }else{
            for(int l=k;l<(m+n);l++){
                arr[l]=arr1[i];
                i++;
            }
        }
        for(int num:arr){
            System.out.println(num+" ");
        }

    }
}
