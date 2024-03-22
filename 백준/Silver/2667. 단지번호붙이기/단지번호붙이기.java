import java.util.*;
import java.io.*;

public class Main {
    static int[] dr = {-1,0,1,0};
    static int[] dc ={0,1,0,-1};
    static int[][] visited;
    static int cnt ,n;
    static boolean[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new boolean[n][n];
        cnt=1;
        visited = new int[n][n];

        for(int i=0;i<n;i++){
            String str = br.readLine();
            for(int j=0;j<n;j++){
               int x = str.charAt(j)-'0';
               if(x==1){
                   arr[i][j]=true;
               }
            }
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(!arr[i][j]||visited[i][j]!=0)continue;
                DFS(i,j);
                cnt++;
            }
        }

        ArrayList<Integer> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        sb.append(cnt-1).append("\n");
        int now =0;
        for(int x=1;x<cnt;x++){
            now =0;
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    if(x==visited[i][j]){
                        now++;
                    }
                }
            }
            list.add(now);

        }


        Collections.sort(list);
        for(int i : list)sb.append(i).append("\n");
        System.out.println(sb.toString());
    }

    private static void DFS(int i,int j) {
        if(!arr[i][j]||visited[i][j]!=0)return;
        visited[i][j]=cnt;

        for(int k=0;k<4;k++){
            int r = i+dr[k];
            int c = j+dc[k];
            if(r>=n||c>=n||r<0||c<0)continue;
            DFS(r,c);
        }
    }

}