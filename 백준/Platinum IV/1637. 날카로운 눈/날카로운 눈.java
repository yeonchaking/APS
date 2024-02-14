import java.io.BufferedReader;
        import java.io.IOException;
        import java.io.InputStreamReader;
        import java.security.spec.RSAOtherPrimeInfo;
        import java.util.*;

public class Main {


    static int n;
    static long[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st ;
        arr = new long[n][3];
        long max = Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            arr[i][0]=Integer.parseInt(st.nextToken());
            arr[i][1]=Integer.parseInt(st.nextToken());
            arr[i][2]=Integer.parseInt(st.nextToken());
            max = Math.max(arr[i][1],max);
        }

        long left = 1;
        long right = max;

        while(left<right){
            long mid = (left+right)/2;
            long x = check(mid);
            if(x%2==0){
                left = mid+1;
            }else {
                right=mid;
            }
        }

        int cnt =0;
        for(int i=0;i<n;i++){
            if(arr[i][0]>left||arr[i][1]<left)continue;
            if((left-arr[i][0])%arr[i][2]==0)cnt++;
        }

        if(cnt%2==0){
            System.out.println("NOTHING");
        }else {
            System.out.println(left+" "+cnt);
        }
//        System.out.println("-------------------");
//        System.out.println(check(1));
//        System.out.println(check(2));
//        System.out.println(check(3));
//        System.out.println(check(4));
//        System.out.println(check(5));
//        System.out.println(check(6));
//        System.out.println(check(7));
//        System.out.println(check(53));
//        System.out.println("=-=-=-=-");
//        System.out.println(check(54));
//        System.out.println("=-=-=-=-");
//        System.out.println(check(55));

    }

    static long check(long x){
//        System.out.println("-------------------");
        long result = 0;
        for(int i=0;i<n;i++){

            if(x<arr[i][0])continue;
            long tmp = (x-arr[i][0]+1)/arr[i][2];
            if(arr[i][1]<x){
                tmp=(arr[i][1]-arr[i][0]+1)/arr[i][2];
                if((arr[i][1]-arr[i][0]+1)%arr[i][2]>0)tmp++;
            }else {
                if((x-arr[i][0]+1)%arr[i][2]>0)tmp++;
            }
            if((arr[i][1]-arr[i][0])<arr[i][2])tmp=1;
            result+=tmp;
//            System.out.println(i+" : "+tmp);
            result%=2;
        }
//        System.out.println(x+" "+result);
        return result;
    }
}