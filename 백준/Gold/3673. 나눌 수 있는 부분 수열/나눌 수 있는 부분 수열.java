import java.awt.image.RasterOp;
import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        long[] prefix;
        int [] cnt = new int[1000001];
        for(int tc=1;tc<=T;tc++) {
            st= new StringTokenizer(br.readLine());
            int d = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());

            prefix = new long[n+1];
            for(int i=1;i<=n;i++){
                prefix[i]=Integer.parseInt(st.nextToken())+prefix[i-1];
            }
            Arrays.fill(cnt,0);
            long result =0;

            long k ;
            for(int i=0;i<=n;i++){
                result+=  cnt[(int)(prefix[i]%d)];
                cnt[(int) (prefix[i]%d)]++;
            }
            sb.append(result+"\n");


        }
        System.out.println(sb.toString());
    }
}