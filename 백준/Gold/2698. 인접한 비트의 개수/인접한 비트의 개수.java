import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int[][] arr = new int[t][2];
        for(int i=0;i<t;i++){
            st = new StringTokenizer(br.readLine());
            arr[i][0]=Integer.parseInt(st.nextToken());
            arr[i][1]=Integer.parseInt(st.nextToken());
        }

        int [][][] dp = new int[101][101][2];

        dp[1][0][1] =1;
        dp[1][0][0] =1;
        for(int i=0; i<101; i++) {
            for(int j=2; j<101; j++) {
                dp[j][i][1] += dp[j-1][i][0];
                if(i!=0) {
                    dp[j][i][1] += dp[j-1][i-1][1];
                }
                dp[j][i][0] += dp[j-1][i][0] + dp[j-1][i][1];
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0;i<t;i++){
            sb.append(dp[arr[i][0]][arr[i][1]][0]+dp[arr[i][0]][arr[i][1]][1]+"\n");
        }
        System.out.println(sb.toString());
    }

}