import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n,m;
    static int[] arr;
    static int left,right;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
         n = Integer.parseInt(st.nextToken());
         m = Integer.parseInt(st.nextToken());
         left=0;
         right=0;
        st = new StringTokenizer(br.readLine());
        arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i]=Integer.parseInt(st.nextToken());
            left=Math.max(left,arr[i]);
            right+=arr[i];
        }

        int mid = 0;
        while(left<=right){
            mid = (left+right)/2;

            int cnt = count(mid);
            if(cnt>m){
                left = mid+1;
            }else {
                right = mid-1;
            }
        }
        System.out.println(left);

        StringBuilder sb = new StringBuilder();
        int cnt = 0;
        int sum = 0;
        int cnt2 = 0;

        for(int i=0;i<n;i++){
            sum+=arr[i];
            if(sum>left){
                cnt2++;
                sum=arr[i];
                sb.append(cnt+" ");
                cnt=1;
            }else {
                cnt++;
            }

            if(m-cnt2==n-i)break;
        }

        while (cnt2<m){
            sb.append(cnt+" ");
            cnt=1;
            cnt2++;
        }
        System.out.println(sb.toString());



    }
    static int count(int x){
        int sum =0;
        int cnt=1;

        for(int i=0;i<n;i++){
            sum+=arr[i];
            if(sum>x){
                cnt++;
                sum=arr[i];
            }
        }
        return cnt;
    }


}