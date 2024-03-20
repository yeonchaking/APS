import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int w = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());

        int[][][][]dp = new int[h][w][2][2];
        int div = 100000;

        for(int i=0;i<h;i++){
            dp[i][0][0][0]=1;
        }
        for(int i=0;i<w;i++){
            dp[0][i][1][0]=1;
        }


        for(int i=1;i<h;i++){
            for(int j=1;j<w;j++){
                dp[i][j][0][0]=dp[i-1][j][0][0]+dp[i-1][j][0][1];
                dp[i][j][0][0]%=div;
                dp[i][j][0][1]=dp[i-1][j][1][0];
                dp[i][j][0][1]%=div;
                dp[i][j][1][0]=dp[i][j-1][1][0]+dp[i][j-1][1][1];
                dp[i][j][1][0]%=div;
                dp[i][j][1][1]=dp[i][j-1][0][0];
                dp[i][j][1][1]%=div;

            }
        }

//       for(int i=0;i<h;i++){
//           for(int j=0;j<w;j++){
//               System.out.print((dp[i][j][0][0]+dp[i][j][0][1]+dp[i][j][1][0]+dp[i][j][1][1])%100000+" ");
//           }
//           System.out.println();
//       }

        System.out.println((dp[h-1][w-1][0][0]+dp[h-1][w-1][0][1]+dp[h-1][w-1][1][0]+dp[h-1][w-1][1][1])%100000);


    }
}