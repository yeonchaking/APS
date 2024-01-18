import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static boolean[] isPrime;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        for (int tc = 1; tc <= T; tc++) {
            int N = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            long[] arr = new long[N];
            long sum = 0;


            for (int i = 0; i < N; i++) {
                arr[i] = Long.parseLong(st.nextToken());
                sum+=arr[i];
            }
            if(check(N,arr[0],arr)) {
                sb.append(0+"\n");
                continue;
            }

            ArrayList<Long> list = new ArrayList<>();
            list.add((long)1);
            list.add(sum);
            for (long i = 2; i <= Math.sqrt(sum); i++) {
                if (sum % i == 0) {
                    list.add(i);
                    list.add(sum / i);
                }
            }

            long min = Long.MAX_VALUE;
            for(long i : list){
                if(check(sum/i,i,arr)){
                   min = Math.min(N-sum/i,min);
                }
            }
            sb.append(min+"\n");

        }
        System.out.println(sb.toString());
    }


    static boolean check(long len, long num, long[] arr){
        int idx =0;
        long sum =0;
        long cnt =0;
        while (idx<arr.length){
            sum+=arr[idx];
            if(sum>num){
                return false;
            } else if (sum<num) {
                idx++;
                continue;
            }else {
                idx++;
                sum=0;
                cnt++;
            }
        }
        return cnt == len;


    }



}