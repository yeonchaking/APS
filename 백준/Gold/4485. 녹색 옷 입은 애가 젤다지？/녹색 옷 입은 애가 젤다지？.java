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
        StringTokenizer st ;
        int idx =1;
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        int[][] cave ;
        int[][] sum ;
        while (n!=0){
            cave = new int[n][n];
            sum = new int[n][n];
            for(int i=0;i<n;i++){
                st = new StringTokenizer(br.readLine());
                for(int j=0;j<n;j++){
                    cave[i][j]=Integer.parseInt(st.nextToken());
                }
            }
            for(int i=0;i<n;i++)Arrays.fill(sum[i],Integer.MAX_VALUE);

            PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    return Integer.compare(o1[2],o2[2]);
                }
            });

            pq.add(new int[]{0,0,cave[0][0]});
            sum[0][0]=cave[0][0];

            while (!pq.isEmpty()){
                int[] now = pq.poll();

                for(int k=0;k<4;k++){
                    int curr = now[0]+dr[k];
                    int curc = now[1]+dc[k];

                    if(curr>=n||curc>=n||curc<0||curr<0)continue;
                    int curw = now[2]+cave[curr][curc];
                    if(sum[curr][curc]>curw){
                        sum[curr][curc]=curw;
                        pq.add(new int[]{curr,curc,curw});
                    }

                }
            }
            sb.append("Problem ").append(idx+": ").append(sum[n-1][n-1]+"\n");
            n = Integer.parseInt(br.readLine());
            idx++;
        }
        System.out.println(sb.toString());




    }
}