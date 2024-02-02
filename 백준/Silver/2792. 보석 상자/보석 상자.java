import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
        static int[] arr;
        static int n,m;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));



        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

       arr = new int[m];
        int max =0;
        for(int i=0;i<m;i++){
            arr[i]=Integer.parseInt(br.readLine());
            max = Math.max(arr[i], max);
        }

        int result = Integer.MIN_VALUE;
        int s = 0;
        int e =max;
        int mid = -1;
        while (s<e){
            mid = (s+e)/2;
//            System.out.println(mid+" "+s+" "+e);
            if(check(mid)){
                e = mid;
            }else {
                s = mid+1;
            }
        }
        System.out.println(e);

    }

    static boolean check(int x){
        int cnt = 0;
        if(x==0)return false;
        for(int i=0;i<m;i++){
            if(arr[i]%x==0){
                cnt+=arr[i]/x;
            }else {
                cnt+=arr[i]/x+1;
            }
        }
        if(cnt>n){
            return false;
        }else {
            return true;
        }

    }

}