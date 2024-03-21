import java.util.*;
import java.io.*;

public class Main {


    static ArrayList<ArrayList<Integer>> list ;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int e = Integer.parseInt(br.readLine());
        StringTokenizer st ;
        list = new ArrayList<>();
        visited = new boolean[n];
        for(int i=0;i<n;i++){
            list.add(new ArrayList<>());
        }

        for(int i=0;i<e;i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken())-1;
            int y = Integer.parseInt(st.nextToken())-1;
            list.get(x).add(y);
            list.get(y).add(x);
        }
        int cnt =0;
        DFS(0);
        for(int i=1;i<n;i++){
            if(visited[i])cnt++;
        }

        System.out.println(cnt);
    }

    private static void DFS(int i) {
        if(visited[i])return;
        visited[i]=true;
        for(int x:list.get(i)){
            DFS(x);
        }
    }

}