import java.awt.image.RasterOp;
import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        long [] arr = new long[N+1];
        long[] prefix = new long[N+1];
        for(int i=1;i<=N;i++){
            arr[i]=Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for(int i=1;i<=N;i++){
            arr[i]-= Integer.parseInt(st.nextToken());
            prefix[i]=arr[i]+prefix[i-1];
        }

        TreeMap<Long,Long> map = new TreeMap<>();
        long cnt =0;
        for(int i=0;i<=N;i++){
            if(map.containsKey(prefix[i])){
                cnt+=map.get(prefix[i]);
            }
            if(map.containsKey(prefix[i])){
                map.put(prefix[i],map.get(prefix[i])+1);
            }else {
                map.put(prefix[i],(long)1);
            }
        }
        System.out.println(cnt);



    }
}