import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());


            long [] arr = new long[100];
            int idx =0;
            while (st.hasMoreTokens()){
                arr[idx++]=Long.parseLong(st.nextToken());
            }

            long max =Long.MIN_VALUE;


            for(int i=0;i<idx;i++){
                for(int j=0;j<idx;j++){
                    if(i==j)continue;
                    max = Math.max(max,getGCD(arr[i],arr[j]));
                }
            }

            System.out.println(max);
        }


    }
    static long getGCD(long x, long y){
        while (y!=0){
            long tmp = y;
         y = x%y;
         x= tmp;
        }
        return x;
    }

}