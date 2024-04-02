import java.util.*;
import java.io.*;

public class Main {

    static int n,m;

    static int[][] tomato;
    static int[][] rotten;
    static Queue<int[]> q;
    static int[] dr = {-1,0,1,0};
    static int[] dc = {0,1,0,-1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        tomato = new int[n][m];
        rotten = new int[n][m];
        q = new LinkedList<>();

        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<m;j++){
                tomato[i][j]=Integer.parseInt(st.nextToken());
                if(tomato[i][j]==-1)rotten[i][j]=-1;
            }
        }

        ArrayList<int[]> list = new ArrayList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(tomato[i][j]==1){
                    list.add(new int[]{i,j});
                }
            }
        }
        BFS(list);

        int max =0;
        boolean check = false;

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(rotten[i][j]==0)check=true;
                max = Math.max(max,rotten[i][j]);
            }
        }
        if(check) System.out.println(-1);
        else System.out.println(max-1);


    }
    static void BFS(ArrayList<int[]> list){
        for(int [] now : list){
            q.add(new int[]{now[0],now[1]});
            rotten[now[0]][now[1]]=1;
        }


        while (!q.isEmpty()){
            int[] now = q.poll();

            for(int k=0;k<4;k++){
                int curr = now[0]+dr[k];
                int curc = now[1]+dc[k];
                if(curr>=n||curc>=m||curr<0||curc<0)continue;
                if(rotten[curr][curc]!=0)continue;
                rotten[curr][curc]=rotten[now[0]][now[1]]+1;
                q.add(new int[]{curr,curc});

            }
        }






    }


}