import java.util.*;
import java.io.*;

public class Main {

    static int n,m;
    static int []wok;
    static Queue<Integer> q;
    static int[] jjajang;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        q = new LinkedList<>();
        wok = new int[m+1];
        st = new StringTokenizer(br.readLine());
        for(int i=1;i<=m;i++){
            wok[i]=Integer.parseInt(st.nextToken());
        }
        jjajang = new int[n+1];
        BFS(0);

        System.out.println(jjajang[n]-1);
    }
    static void BFS(int x){

        q.add(x);
        jjajang[x]=1;

        while (!q.isEmpty()){
            int now = q.poll();
            for(int i=0;i<=m;i++){
                for(int j=0;j<=m;j++){
                    if(i==j)continue;
                    if(now+wok[i]+wok[j]>n)continue;
                    if(jjajang[now+wok[i]+wok[j]]!=0)continue;
                    jjajang[now+wok[i]+wok[j]] =jjajang[now]+1;
                    q.add(now+wok[i]+wok[j]);

                }
            }
        }

    }


}