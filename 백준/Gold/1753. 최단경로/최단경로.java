import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.security.spec.RSAOtherPrimeInfo;
import java.util.*;

public class Main {
    static int INF = Integer.MAX_VALUE;
    static class Node implements Comparable<Node>{
        int v,w;
        public Node(int v, int w){
            this.v=v;
            this.w=w;
        }
        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.w,o.w);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
       PriorityQueue<Node> pq = new PriorityQueue<>();
        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        int k = Integer.parseInt(br.readLine());
        ArrayList<Node>[] adjList = new ArrayList[v+1];

        for(int i=0;i<=v;i++)adjList[i]=new ArrayList<>();
        for(int i=0;i<e;i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());

            adjList[x].add(new Node(y,z));
        }

       int[] dist = new int[v+1];
        Arrays.fill(dist,INF);

        dist[k]=0;
        pq.add(new Node(k,0));

        while (!pq.isEmpty()){
            Node now = pq.poll();
            if(dist[now.v]<now.w)continue;

            for(Node n : adjList[now.v]){
                int cur = dist[now.v]+n.w;
                if(dist[n.v]>cur){
                    dist[n.v]=cur;
                    pq.add(new Node(n.v,cur));
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i=1;i<=v;i++){
            if(dist[i]==INF)sb.append("INF").append("\n");
            else sb.append(dist[i]).append("\n");
        }
        System.out.println(sb.toString());
    }
}