import java.io.BufferedReader;
        import java.io.IOException;
        import java.io.InputStreamReader;
        import java.security.spec.RSAOtherPrimeInfo;
        import java.util.*;

public class Main {
    static int n,s;
    static int[] arr;
    static boolean[] visited;
    static int max;

    static int[] result ;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n= Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new int[n];
        visited = new boolean[n];
        result = new int[n];
        max = Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            arr[i]=Integer.parseInt(st.nextToken());
        }
        recur(0);
        System.out.println(max);
    }

    static void recur(int cur){
        if(cur==n){
            int sum = 0;
            for(int i=0;i<n-1;i++){
                sum+=Math.abs(result[i+1]-result[i]);
            }
            max= Math.max(max,sum);
            return;
        }

        for(int i=0;i<n;i++){
            if(visited[i])continue;
            visited[i]=true;
            result[cur]=arr[i];
            recur(cur+1);
            visited[i]=false;
        }
    }
}