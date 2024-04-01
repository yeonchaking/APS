import java.util.*;
import java.io.*;

public class Main {

    static int n,m;
    static Queue<Integer> q ;

    static ArrayList<ArrayList<Integer>> adjList;
    static int[] kb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        adjList = new ArrayList<>();
        for(int i=0;i<n;i++)adjList.add(new ArrayList<>());
        for(int i=0;i<m;i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken())-1;
            int y = Integer.parseInt(st.nextToken())-1;
            adjList.get(x).add(y);
            adjList.get(y).add(x);
        }

        q = new LinkedList<>();
        int min = Integer.MAX_VALUE;
        int last = -1;
        for(int i=0;i<n;i++){
            kb = new int[n];
            BFS(i);
            int sum = 0;
            for(int j=0;j<n;j++)sum+=kb[j];
            if(min>=sum){
                if(min==sum)last = Math.min(last,i);
                else last=i;
                min = sum;
            }
        }

        System.out.println(last+1);
//        System.out.println(min);

    }
    static void BFS(int x){
        q.add(x);
        kb[x]=1;

        while (!q.isEmpty()){
            int now = q.poll();
            for(int i : adjList.get(now)){
                if(kb[i]!=0)continue;
                kb[i]=kb[now]+1;
                q.add(i);
            }
        }



    }




}