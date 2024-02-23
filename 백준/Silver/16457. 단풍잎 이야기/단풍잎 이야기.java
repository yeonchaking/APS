import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {


    static int n,m,k,size,max;
    static int[][] quest ;
    static int[] skillSet;
    static boolean[] visited;
    static TreeSet<Integer> set ;



    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        max = 0;
        quest = new int[m][k];
        TreeSet<Integer> skill = new TreeSet<>();
        for(int i=0;i<m;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<k;j++){
                quest[i][j]=Integer.parseInt(st.nextToken());
                skill.add(quest[i][j]);
            }
        }
        size = skill.size();

        skillSet = new int[size];
        visited = new boolean[size];
        int idx= 0;
        for(int i : skill){
            skillSet[idx++]=i;
        }
        recur(0,0);

        if(size<=n) System.out.println(m);
        else System.out.println(max);

    }

    static void recur(int cur,int cnt){
        if(cur==size){
            if(cnt==n)max = Math.max(max,check());
            return;
        }
        visited[cur]=true;
        recur(cur+1,cnt+1);
        visited[cur]=false;
        recur(cur+1,cnt);

    }

    static int check(){
        int cnt =0;
        set = new TreeSet<>();
        for(int i=0;i<size;i++){
            if(visited[i])set.add(skillSet[i]);
        }
        outer : for(int i=0;i<m;i++){
            for(int j=0;j<k;j++){
                if(!set.contains(quest[i][j])){
                    continue outer;
                }
            }
            cnt++;
        }
        return cnt;
    }



}