import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
        static int[] arr;
        static int n,k;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

       arr = new int[n];
        int max =0;
        for(int i=0;i<n;i++){
            arr[i]=Integer.parseInt(br.readLine());
            max = Math.max(arr[i], max);
        }

        int result = Integer.MIN_VALUE;
        long s = 0;
        long e =max+1;
        long mid = 0;
        while (s<e){
            mid = (s+e)/2;
//            System.out.println(mid+" "+s+" "+e);
            if(check(mid)){
                e = mid;
            }else {
                s = mid+1;
            }
        }
        if(e==0){
            System.out.println(0);
        }else {
            System.out.println(e - 1);
        }

    }

    static boolean check(long x){
        long cnt = 0;
        if(x==0)return false;
        for(int i=0;i<n;i++)cnt+=arr[i]/x;
//        System.out.println(cnt+" "+k);
        return cnt < k;
    }

}