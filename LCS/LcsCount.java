package Try.LCS;

public class LcsCount {
    public static int findLongest(String A, int n, String B, int m) {
        // write code here
        int[][] arr=new int[n+1][m+1];
        int maxlen=0;
        //int end=0;
        for(int i=1;i<n+1;i++){
            for(int j=1;j<m+1;j++){
                if(A.charAt(i-1)==B.charAt(j-1)){
                    arr[i][j]=arr[i-1][j-1]+1;

                }
                else{
                    arr[i][j]=0;
                }
                if(maxlen<arr[i][j]){
                   // end=i;
                    maxlen=arr[i][j];
                }
            }
        }

        return maxlen;

    }

    public static void main(String[] args) {
        String st1="bcbab";
        String st2="abbabccc";
        System.out.println(findLongest(st1, st1.length(), st2, st2.length()));
    }
}
