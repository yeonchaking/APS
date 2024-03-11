import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int n,min;
    static int[][] arr;
    static int[][] dp;


    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        min =Integer.MAX_VALUE;
        StringTokenizer st ;
        arr = new int[n][3];
        dp = new int[n][3];
        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<3;j++){
                arr[i][j]=Integer.parseInt(st.nextToken());
            }
        }

        dp[0][0]=arr[0][0];
        dp[0][1]=arr[0][1];
        dp[0][2]=arr[0][2];
        for(int i=1;i<n;i++){

            for(int j=0;j<3;j++){
                if(j==0)dp[i][j]=Math.min(dp[i-1][1],dp[i-1][2])+arr[i][0];
                else if(j==1)dp[i][j]=Math.min(dp[i-1][0],dp[i-1][2])+arr[i][1];
                else dp[i][j]=Math.min(dp[i-1][1],dp[i-1][0])+arr[i][2];
            }
        }


        for(int i=0;i<3;i++){
            min = Math.min(min,dp[n-1][i]);
        }
        System.out.println(min);

    }


}