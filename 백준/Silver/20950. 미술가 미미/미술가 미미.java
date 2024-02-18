import java.io.BufferedReader;
        import java.io.IOException;
        import java.io.InputStreamReader;
        import java.security.spec.RSAOtherPrimeInfo;
        import java.util.*;

public class Main {

    static int n;
    static int[][] arr;
    static int[] gom;
    static boolean[] visited;
    static int min;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        arr = new int[n][3];
        visited = new boolean[n];
        gom = new int[3];
        min = Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            arr[i][0]=Integer.parseInt(st.nextToken());
            arr[i][1]=Integer.parseInt(st.nextToken());
            arr[i][2]=Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<3;i++)gom[i]=Integer.parseInt(st.nextToken());

        recur(0,0);
        System.out.println(min);

    }

    static void recur(int cur,int cnt){
        if(cur==n){
            if(cnt<2||cnt>7)return;
            int []sum ={0,0,0};
            for(int i=0;i<n;i++){
                for(int j=0;j<3;j++){
                    if(visited[i]){
                        sum[j]+=arr[i][j];
                    }
                }
            }
            int tmp = 0;
            for(int i=0;i<3;i++){
                sum[i]=Math.abs(sum[i]/cnt-gom[i]);
                tmp += sum[i];
            }
            min = Math.min(tmp,min);
            return;
        }

        if(cnt>7)return;

        visited[cur]=true;
        recur(cur+1,cnt+1);
        visited[cur]=false;
        recur(cur+1,cnt);
    }


}