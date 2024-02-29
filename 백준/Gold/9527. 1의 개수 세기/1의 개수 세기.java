import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static long[] p ;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());
        p = new long[60];
        p[0]=1;
        for(int i=1;i<60;i++){
            p[i]=p[i-1]*2;
        }
        System.out.println(getOneCount(b)-getOneCount(a-1));
    }
    static long getOneCount(long x){
        long cnt=0;
        x++;
        int co =1;

        while(p[co-1]<=x){
            cnt+= (x-(x%p[co]))/2;
            cnt+= Math.max(0,x%p[co]-p[co-1]);
            co++;
        }
        return cnt;
    }
}