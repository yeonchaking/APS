import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine()) + 1;
        long div = 1000000007;
        long [][]dp = new long[1002][2];
        dp[1][0] = 1;
        dp[1][1] = 0;
        dp[2][0] = 1;
        dp[2][1] = 0;
        dp[3][0] = 2;
        dp[3][1] = 1;


        for(int i=4;i<=N;i++){
            // dp[i-1][0] = i-1 에서 걸어온경우
            // dp[i-2][0] = i-2 에서 1을 점프해서 온 경우
            // dp[i-3][0] = i-3 에서 1 1 을 점프해서 온 경우
            dp[i][0] = (dp[i-1][0] + dp[i-2][0] + dp[i-3][0])%div;

            // dp[i-1][1] = i-1 에서 걸어온경우
            // dp[i-2][0] + dp[i-2][1]*2 = i-2 에서 2을 점프해서 온 경우 + i-2에서 1을 점프, 2을 점프해서 온 경우
            // dp[i-3][0]*2 + dp[i-3][1]*3 = i-3 에서 1 2 / 2 1 을 점프해서 온 경우 +
            // i-3 에서 1 1 / 1 2 / 2 1 을 점프해서 온 경우
            dp[i][1] = (dp[i-1][1] + dp[i-2][0] + dp[i-2][1]*2 + dp[i-3][0]*2 + dp[i-3][1]*3)%div;
        }
        System.out.println(dp[N][1]);

    }

}