import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());

        int[] arr = new int[T + 1];
        for (int i = 1; i <= T; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int now =1;
        int[][] dp = new int[T + 1][W + 1];
        int answer = 0;
        for (int t = 1; t <= T; t++) {
            int treeNow = arr[t];
            for (int w = 0; w <= W; w++) {
                if(w==0){
                    now=1;
                    if (treeNow == now) dp[t][0] = dp[t - 1][0] + 1;
                    else  dp[t][0] = dp[t - 1][0];
                    continue;
                }
                if(w % 2 == 0) now = 1;
                else now = 2;
                if(now == treeNow)  dp[t][w] = Math.max(dp[t-1][w] + 1, dp[t-1][w-1]);
                else    dp[t][w] = Math.max(dp[t-1][w-1] + 1, dp[t-1][w]);
                answer = Math.max(answer, dp[t][w]);
            }
        }

        System.out.println(answer);
    }
}