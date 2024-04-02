import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.security.spec.RSAOtherPrimeInfo;
import java.util.*;

public class Main {

    static int n,m;
    static int[][] robot;
    static int[][][] visited;
    static Queue<int[]>q;
    static int[]start ;
    static int[] end;

    static int[] dr = {0,0,1,-1};
    static int[] dc = {1,-1,0,0};
    static int cnt =0;



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        q = new LinkedList<>();
        robot = new int[n][m];
        visited = new int[n][m][4];

        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<m;j++){
                robot[i][j]=Integer.parseInt(st.nextToken());
            }
        }
        start = new int[3];
        end = new int[3];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<3;i++)start[i]=Integer.parseInt(st.nextToken())-1;
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<3;i++)end[i]=Integer.parseInt(st.nextToken())-1;

        BFS(start[0],start[1],start[2]);

//        for(int i=0;i<n;i++){
//            for(int j=0;j<m;j++){
//                System.out.print(Arrays.toString(visited[i][j])+" ");
//            }
//            System.out.println();
//        }

        System.out.println(visited[end[0]][end[1]][end[2]]-1);


    }

    static void BFS(int r, int c, int dir) {
        q.add(new int[]{r,c,dir});
        visited[r][c][dir]=1;

        while (!q.isEmpty()){
            int[] now = q.poll();
//            System.out.println();
//            for(int i=0;i<n;i++){
//                for(int j=0;j<m;j++){
//                    System.out.print(Arrays.toString(visited[i][j])+" ");
//                }
//                System.out.println();
//            }
            int[] cur = new int[now.length];
            for(int k=0;k<5;k++){

                System.arraycopy(now, 0, cur, 0, now.length);

                if(k==0){
                    if(now[2]==0)cur[2]=3;
                    else if(now[2]==1)cur[2]=2;
                    else if(now[2]==2)cur[2]=0;
                    else if(now[2]==3)cur[2]=1;
                }else if (k==1){
                    if(now[2]==0)cur[2]=2;
                    else if(now[2]==1)cur[2]=3;
                    else if(now[2]==2)cur[2]=1;
                    else if(now[2]==3)cur[2]=0;
                }else if(k==2){
                    cur[0]+=dr[cur[2]];
                    cur[1]+=dc[cur[2]];
                } else if (k==3) {
                    if(now[0]+dr[cur[2]]>=n||now[0]+dr[cur[2]]<0||now[1]+dc[cur[2]]>=m||now[1]+dc[cur[2]]<0)continue;
                    if(robot[now[0]+dr[cur[2]]][now[1]+dc[cur[2]]]==1)continue;
                    cur[0]+=dr[cur[2]]*2;
                    cur[1]+=dc[cur[2]]*2;
                } else if (k==4) {
                    if(now[0]+dr[cur[2]]>=n||now[0]+dr[cur[2]]<0||now[1]+dc[cur[2]]>=m||now[1]+dc[cur[2]]<0)continue;
                    if(now[0]+dr[cur[2]]*2>=n||now[0]+dr[cur[2]]*2<0||now[1]+dc[cur[2]]*2>=m||now[1]+dc[cur[2]]*2<0)continue;
                    if(robot[now[0]+dr[cur[2]]][now[1]+dc[cur[2]]]==1)continue;
                    if(robot[now[0]+dr[cur[2]]*2][now[1]+dc[cur[2]]*2]==1)continue;
                    cur[0]+=dr[cur[2]]*3;
                    cur[1]+=dc[cur[2]]*3;

                }
                if(cur[0]>=n||cur[1]>=m||cur[0]<0||cur[1]<0)continue;
                if(robot[cur[0]][cur[1]]==1)continue;
                if(visited[cur[0]][cur[1]][cur[2]]==0||visited[cur[0]][cur[1]][cur[2]]>visited[now[0]][now[1]][now[2]]+1){
                    cnt++;
                    visited[cur[0]][cur[1]][cur[2]]=visited[now[0]][now[1]][now[2]]+1;
                    q.add(new int[]{cur[0],cur[1],cur[2]});
                }


            }




        }


    }
}