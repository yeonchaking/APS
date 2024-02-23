import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {


    static int n,m,max;
    static int[][] mara;
    static boolean[] visited;


    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        max = Integer.MIN_VALUE;

        mara = new int[n][n];
        visited = new boolean[n];
        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<n;j++){
                mara[i][j]=Integer.parseInt(st.nextToken());
            }
        }

        recur(0,0);


        System.out.println(max);

    }

    static void recur(int cur,int cnt){
        if(cur==n){
            if(cnt!=m)return;
            max = Math.max(check(),max);
            return;
        }

        visited[cur]=true;
        recur(cur+1,cnt+1);
        visited[cur]=false;
        recur(cur+1,cnt);



    }

    static int check(){
        int num = 0;
        int [] ma = new int[m];
        int idx =0;
        for(int i=0;i<n;i++){
            if(visited[i])ma[idx++]=i;
        }
        for(int i : ma){
            for(int j : ma){
                num+=mara[i][j];
            }
        }
        return num/2;
    }



}