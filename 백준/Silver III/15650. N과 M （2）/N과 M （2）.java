import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int n,m;
    static int[] result;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        result = new int[m];
        visited =  new boolean[n+1];


        recur(0);



    }

    static void recur(int cur){

        if(cur>=m){
            for(int i=0;i<m;i++){
                System.out.print(result[i]+" ");
            }
            System.out.println();
            return;
        }



        for(int i=1;i<=n;i++){
            if(visited[i])continue;
            if(cur!=0&&result[cur-1]>i)continue;
            visited[i]=true;
            result[cur]=i;
            recur(cur+1);
            visited[i]=false;
        }

    }

}