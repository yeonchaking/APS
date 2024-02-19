import java.io.BufferedReader;
        import java.io.IOException;
        import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

        static int n, L, R, X,count;
        static int [] Q;
        static boolean [] contain;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        Q= new int[n];
        contain = new boolean[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            Q[i]=Integer.parseInt(st.nextToken());
        }
        recur(0,0);

        System.out.println(count);

    }

    static void recur(int cur,int cnt){
        if(cur==n){
            if(cnt<2)return;
            int sum = 0;
            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;
            for(int i=0;i<n;i++){
                if(contain[i]){
                    sum+=Q[i];
                    min = Math.min(min,Q[i]);
                    max = Math.max(max,Q[i]);
                }
            }
            if(sum>=L&&sum<=R&&X<=(max-min)){
                count++;
            }
            return;
        }

        contain[cur]=true;
        recur(cur+1,cnt+1);
        contain[cur]=false;
        recur(cur+1,cnt);

    }




}