import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n;
    static int[] parent;
    static boolean[]visited;
    static  ArrayList<Integer>[] adjList;


    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        parent = new int[n+1];
        visited = new boolean[n+1];
        StringTokenizer st ;
        adjList = new ArrayList[n+1];

        for(int i=1;i<=n;i++)adjList[i]= new ArrayList<>();

        for(int i=0;i<n-1;i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            adjList[x].add(y);
            adjList[y].add(x);
        }

        dfs(1);

        StringBuilder sb = new StringBuilder();
        for(int i=2;i<=n;i++)sb.append(parent[i]+"\n");
        System.out.println(sb.toString());
    }

    static void dfs(int x){
        visited[x]=true;
        for(int i : adjList[x]){
            if(visited[i])continue;
            parent[i]=x;
            dfs(i);
        }
    }


}