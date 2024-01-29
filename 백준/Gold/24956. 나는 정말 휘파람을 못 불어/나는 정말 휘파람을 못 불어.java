import java.awt.image.RasterOp;
import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        String str = br.readLine();

        char[] arr = str.toCharArray();

        long [] prefix = new long[3];
        long mod = 1000000007;
        long ans = 0;
//        System.out.println(Arrays.toString(prefix));
        for(int i=0;i<N;i++){
            if(arr[i]=='W'){
                prefix[0]++;
                prefix[0]%=mod;
            } else if (arr[i]=='H') {
                prefix[1]+=prefix[0];
                prefix[1]%=mod;
            } else if (arr[i]=='E') {
                ans+=prefix[2];
                prefix[2]*=2;
                prefix[2]+=prefix[1];
                prefix[2]%=mod;
            }
            ans%=mod;
//            System.out.println(Arrays.toString(prefix)+" "+ans);
        }
        System.out.println(ans);

    }

}