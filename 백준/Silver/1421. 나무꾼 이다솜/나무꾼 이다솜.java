import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        long [] arr = new long[n];
        long max = 0;
        for(int i=0;i<n;i++){
            arr[i]=Long.parseLong(br.readLine());
            max = Math.max(arr[i],max);
        }

        long result = Long.MIN_VALUE;
        for(int i=1;i<=max;i++){
            long sum =0;
            for(int j=0;j<n;j++){
                long cut =0;
                if(arr[j]%i==0){
                    cut += arr[j]/i-1;
                }else {
                    cut +=arr[j]/i;
                }

                if(k*i*(arr[j]/i)-cut*c>0)sum+=k*i*(arr[j]/i)-cut*c;
            }
            result=Math.max(result,sum);
        }

        System.out.println(result);







    }


}