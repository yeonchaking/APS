import java.util.*;
import java.io.*;

public class Main {
    static int n,m;
    static int[][] arr ;
    static int[][] step;
    static int[] dr = {-1,0,1,0};
    static int[] dc ={0,1,0,-1};
    static Queue<int[]> q;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        q = new LinkedList<>();

        arr = new int[n][m];
        step = new int[n][m];

        for(int i=0;i<n;i++){
            String str = br.readLine();
            for(int j=0;j<m;j++){
                arr[i][j]=str.charAt(j)-'0';
            }
        }

        BFS(0,0);
        System.out.println(step[n-1][m-1]);

    }

    static void BFS(int r, int c){
        q.add(new int[]{r,c});
        step[r][c]=1;

        while (!q.isEmpty()){
            int [] now = q.poll();

            for(int k=0;k<4;k++){
                int curr = now[0]+dr[k];
                int curc = now[1]+dc[k];

                if(curr>=n||curc>=m||curr<0||curc<0)continue;

                if(step[curr][curc]==0&&arr[curr][curc]==1){
                    step[curr][curc]=step[now[0]][now[1]]+1;
                    q.add(new int[]{curr,curc});
                }
            }

        }

    }


}