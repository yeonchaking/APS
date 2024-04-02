import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    static int n,k;
    static Queue<Integer> q ;
    static int[] visited;
    static int answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        q = new LinkedList<>();
        visited = new int[100010];
        answer = 0;

        BFS(n);

        System.out.println(visited[k]-1);



    }

    static void BFS(int x) {
        q.add( x);
        visited[x]=1;

        while(!q.isEmpty()) {
            int now = q.poll();
            int two = now*2;
            while (two<=100000&&two>0){
                if(visited[two]==0){
                    visited[two]=visited[now];
                    q.add(two);
                }else if(visited[two]>visited[now]){
                    visited[two]=visited[now];
                    q.add(two);
                }
                two*=2;
            }
            if(visited[k]!=0)return;
            for(int k=0;k<2;k++) {
                if(k==0) {
                    if(now+1>100000) continue;
                    if(visited[now+1]!=0)continue;
                    q.add(now+1);
                    visited[now+1]=visited[now]+1;
                }else if(k==1) {
                    if(now-1<0) continue;
                    if(visited[now-1]!=0)continue;
                    q.add(now-1);
                    visited[now-1]=visited[now]+1;
                }
            }
        }
    }
}
