import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i]=Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);
        if(arr[0]>k) System.out.println(0);
        int [][] dp = new int[n][k+1];

        for(int i=0;i<n;i++){

            for(int j=1;j<=k;j++){
                if(i==0){
                    if(j%arr[i]==0){
                        dp[i][j]=1;
                    }
                }else {
                    if(j>arr[i])dp[i][j]=dp[i-1][j]+dp[i][j-arr[i]];
                    else if(j==arr[i])dp[i][j]=dp[i-1][j]+1;
                    else dp[i][j]=dp[i-1][j];
                }
            }
        }

        System.out.println(dp[n-1][k]);






    }
}