import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int n,w,max;

    static int[][] dp;

    static int[][] arr ;



    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());
        max =0;
        dp = new int[n+1][w+1];
        arr = new int[n+1][2];
        for(int i=1;i<=n;i++){
            st=  new StringTokenizer(br.readLine());
            arr[i][0]= Integer.parseInt(st.nextToken());
            arr[i][1]= Integer.parseInt(st.nextToken());
        }


        for(int i=1;i<=n;i++){
            for(int j=1;j<=w;j++){
                if(arr[i][0]>j){
                    dp[i][j]=dp[i-1][j];
                }else {
                    dp[i][j]=Math.max(dp[i-1][j],dp[i-1][j-arr[i][0]]+arr[i][1]);
                }
            }
        }

        System.out.println(dp[n][w]);

    }




}