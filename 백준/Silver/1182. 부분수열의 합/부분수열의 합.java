import java.io.BufferedReader;
        import java.io.IOException;
        import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int n,m,cnt;
    static int[] arr;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n =  Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        cnt = 0;
        arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            arr[i]=Integer.parseInt(st.nextToken());
        }
        recur(0,0,false);
        System.out.println(cnt);
    }

    static void recur(int cur,int sum,boolean check){
        if(cur==n){
            if(sum==m&&check){
                cnt++;
            }
            return;
        }

        recur(cur+1,sum+arr[cur],true);
        recur(cur+1,sum,check);
    }



}