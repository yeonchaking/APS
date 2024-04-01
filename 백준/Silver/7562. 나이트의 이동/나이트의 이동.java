import java.util.*;
import java.io.*;

public class Main {

    static int n;
    static int[] start ;
    static int[] end;
    static int[][] step;
    static int[] dr ={-2,-1,1,2,2,1,-1,-2};
    static int[] dc ={1,2,2,1,-1,-2,-2,-1};

    static Queue<int[]> q ;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st ;
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb   = new StringBuilder();
        for(int tc=1;tc<=T;tc++){

            n = Integer.parseInt(br.readLine());
            step= new int[n][n];
            st = new StringTokenizer(br.readLine());
            start = new int[]{Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())};
            st = new StringTokenizer(br.readLine());
            end = new int[]{Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())};
            q = new LinkedList<>();
            BFS(start[0],start[1]);

            sb.append(step[end[0]][end[1]]-1).append("\n");
        }
        System.out.println(sb.toString());


    }
    static void BFS(int r, int c){

        q.add(new int[]{r,c});
        step[r][c]=1;

        while(!q.isEmpty()) {
//            System.out.println("gd");
            int[] now = q.poll();
            for (int k = 0; k < 8; k++) {
                int curr = now[0] + dr[k];
                int curc = now[1] + dc[k];


                if (curr >= n || curc >= n || curr < 0 || curc < 0) continue;
                if(step[curr][curc]==0) {
                    step[curr][curc] = step[now[0]][now[1]] + 1;
                    q.add(new int[]{curr, curc});
                }
            }
        }
    }




}