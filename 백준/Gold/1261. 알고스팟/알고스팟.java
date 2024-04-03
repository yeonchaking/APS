import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.security.spec.RSAOtherPrimeInfo;
import java.util.*;

public class Main {
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
    static int[] dr ={-1,0,1,0};
    static int[] dc ={0,1,0,-1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        int[][] maze = new int[n][m];
        for(int i=0;i<n;i++){
            String str = br.readLine();
            for(int j=0;j<m;j++){
                maze[i][j]=str.charAt(j)-'0';
            }
        }
        int[][] dist = new int[n][m];
        int INF = Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                dist[i][j]=INF;
            }
        }
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0,0,0});
        dist[0][0]=0;
        while (!q.isEmpty()){
            int[] now = q.poll();
            for(int k=0;k<4;k++){
                int curr = now[0]+dr[k];
                int curc = now[1]+dc[k];
                int curw = now[2];
                if(curr>=n||curc>=m||curr<0||curc<0)continue;
                if(maze[curr][curc]==1)curw++;

                if(dist[curr][curc]>curw){
                    q.add(new int[]{curr,curc,curw});
                    dist[curr][curc]=curw;
                }
            }
        }

//        System.out.println(Arrays.deepToString(dist));
        System.out.println(dist[n-1][m-1]);




    }
}