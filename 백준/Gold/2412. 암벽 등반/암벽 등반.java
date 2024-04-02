import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int n, t;
    static int[][] node;
    static Queue<Integer> q;
    static int[] visited;
    static int answer;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());
        q = new LinkedList<>();
        visited = new int[n+1];


        node = new int[n+1][2];
        for(int i=1;i<=n;i++){
            st = new StringTokenizer(br.readLine());
            node[i][0]=Integer.parseInt(st.nextToken());
            node[i][1]=Integer.parseInt(st.nextToken());
        }

        Arrays.sort(node, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0]==o2[0])return o1[1]-o2[1];
                return o1[0]-o2[0];
            }
        });
        answer = -1;
        BFS();

        if(answer<0) System.out.println(answer);
        else System.out.println(answer-1);


    }

    static void BFS() {
        q.add(0);
        visited[0]=1;

        while (!q.isEmpty()){
            int  now = q.poll();
            if(node[now][1]==t){
                answer = visited[now];
                return;
            }
            int idx = now;
            while(node[now][0]-2<=node[idx][0]&&idx>0){
                idx--;
                if(visited[idx]!=0)continue;
                if(node[idx][0]>node[now][0]+2||node[idx][0]<node[now][0]-2||node[idx][1]>node[now][1]+2||node[idx][1]<node[now][1]-2)continue;
                visited[idx]=visited[now]+1;
                q.add(idx);
            }
            while(node[now][0]+2>=node[idx][0]&&idx<n){
                idx++;
                if(visited[idx]!=0)continue;
                if(node[idx][0]>node[now][0]+2||node[idx][0]<node[now][0]-2||node[idx][1]>node[now][1]+2||node[idx][1]<node[now][1]-2)continue;
                visited[idx]=visited[now]+1;
                q.add(idx);
            }
        }
    }
}