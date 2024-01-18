import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            arr[i]=Integer.parseInt(st.nextToken());
        }
        int a =0,b=0;

        int cnt =0;
        int sum =arr[0];
        while (a<n&&b<n){

            if(sum>m){
                sum-=arr[a];
                a++;
            } else if (sum<m) {
                b++;
                if(b<n){
                    sum+=arr[b];
                }else break;
            }else {
//                System.out.println(a+" "+b);
                cnt++;
                sum-=arr[a];
                a++;
                b++;
                if(b<n){
                    sum+=arr[b];
                }else break;
            }
        }
        System.out.println(cnt);

    }


}