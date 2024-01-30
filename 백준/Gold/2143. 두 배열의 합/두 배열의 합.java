import java.awt.image.RasterOp;
import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T =Integer.parseInt(br.readLine());
        int N =Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        long [] A = new long[N+1];
        long [] Aprefix = new long[N+1];

        for(int i=1;i<=N;i++){
            A[i]=Integer.parseInt(st.nextToken());
            Aprefix[i]=A[i]+Aprefix[i-1];
        }
        TreeMap<Long,Long> Amap = new TreeMap<>();
        for(int i=0;i<N;i++){
            for(int j=i+1;j<=N;j++){
                long dif =Aprefix[j]-Aprefix[i];
                if(Amap.containsKey(dif)){
                    Amap.put(dif,Amap.get(dif)+1);
                }else {
                    Amap.put(dif,(long)1);
                }
            }
        }

        int M =Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        long [] B = new long[M+1];
        long [] Bprefix = new long[M+1];
        for(int i=1;i<=M;i++){
            B[i]=Integer.parseInt(st.nextToken());
            Bprefix[i]=B[i]+Bprefix[i-1];
        }
        TreeMap<Long,Long> Bmap = new TreeMap<>();
        for(int i=0;i<M;i++){
            for(int j=i+1;j<=M;j++) {
                long dif =Bprefix[j]-Bprefix[i];
                if(Bmap.containsKey(dif)){
                    Bmap.put(dif,Bmap.get(dif)+1);
                }else {
                    Bmap.put(dif,(long)1);
                }
            }
        }
        long cnt = 0;
        for(long i : Amap.keySet()){
            if(Bmap.containsKey(T-i)){
               cnt+=(Amap.get(i)*Bmap.get(T-i));
            }

        }

        System.out.println(cnt);


        }
}