import java.util.*;
import java.io.*;

public class Main {

    static int n,m,cnt;
    static int [] answer;
    static boolean[] visited;
    static ArrayList<ArrayList<Integer>> adjList;
    static boolean check;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        answer = new int[2];
        answer[0]=Integer.parseInt(st.nextToken());
        answer[1]=Integer.parseInt(st.nextToken());
         m = Integer.parseInt(br.readLine());
        cnt=0;
        adjList = new ArrayList<>();
        visited = new boolean[n+1];
        check = false;
        for(int i=0;i<=n;i++)adjList.add(new ArrayList<>());

        for(int i=0;i<m;i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            adjList.get(x).add(y);
            adjList.get(y).add(x);

        }

        visited[answer[0]]=true;
        DFS(answer[0]);
        if(!check){
            System.out.println(-1);
        }

    }

    static void DFS(int x){
        if(x==answer[1]){
            System.out.println(cnt);
            check= true;
            return;
        }
        for(int i:adjList.get(x)){
            if(visited[i])continue;
            visited[i]=true;
            cnt++;
            DFS(i);
            cnt--;
        }

    }


}