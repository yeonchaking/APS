import java.io.BufferedReader;
        import java.io.IOException;
        import java.io.InputStreamReader;
        import java.security.spec.RSAOtherPrimeInfo;
        import java.util.*;

public class Main {
    static int n,s;
    static int[] arr;
    static boolean[] visited;
    static int cnt;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n= Integer.parseInt(st.nextToken());
        s= Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        arr = new int[n];
        visited = new boolean[n];
        cnt=0;
        for(int i=0;i<n;i++){
            arr[i]=Integer.parseInt(st.nextToken());
        }


            recur(0);

        System.out.println(cnt);


    }

    static void recur(int cur){

        if(cur==n){
            int sum = 0;
            boolean c=false;
            for(int i=0;i<n;i++){
                if(visited[i]){
                    sum+=arr[i];
                    c=true;
                }
            }

            if(sum==s&&c){
//                System.out.println(Arrays.toString(visited));
                cnt++;
            }
            return;
        }




            recur(cur+1);
            visited[cur]=true;
            recur(cur+1);
            visited[cur]=false;

    }
}