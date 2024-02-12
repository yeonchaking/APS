import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        long x =  Long.parseLong(st.nextToken());
        st = new StringTokenizer(br.readLine());
        long [] arr = new long[n];
        int cnt = 0;
        for(int i=0;i<n;i++){
            arr[i]=Long.parseLong(st.nextToken());
            if(arr[i]==x)cnt++;
        }

        Arrays.sort(arr);
        int s = 0;
        int e = n-cnt-1;
        double half = (double) x /2;
        int cut = 0;
        while (s<=e){
            long sum = arr[s]+arr[e];
            if(s==e){
                cut++;
                break;
            }
            if(sum>=half){
                s++;
                e--;
                cnt++;
            } else  {
                cut++;
                s++;
            }
        }
        cnt+= cut/3;

        System.out.println(cnt);


    }




}