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

        int k = Integer.parseInt(st.nextToken());
        ArrayList<Node>[] adjList = new ArrayList[v+1];

        for(int i=0;i<=v;i++)adjList[i]=new ArrayList<>();
        for(int i=0;i<e;i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());

            adjList[x].add(new Node(y,z));
        }

        int[][] dist = new int[v+1][v+1];
        for(int i=1;i<=v;i++)Arrays.fill(dist[i],INF);


        for(int i=1;i<=v;i++){
            dist[i][i]=0;
            pq.add(new Node(i,0));

            while (!pq.isEmpty()){
                Node now = pq.poll();
                if(dist[i][now.v]<now.w)continue;

                for(Node n : adjList[now.v]){
                    int cur = dist[i][now.v]+n.w;
                    if(dist[i][n.v]>cur){
                        dist[i][n.v]=cur;
                        pq.add(new Node(n.v,cur));
                    }
                }
            }
        }
        int max =0;
        for(int i=1;i<=v;i++)max = Math.max(dist[i][k]+dist[k][i],max);

        System.out.println(max);






    }
}