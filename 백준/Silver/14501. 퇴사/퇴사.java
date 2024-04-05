import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {


    static int n,max;
    static boolean[] visited;
    static int [][] pay;

    static int [] job;



    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st ;
        visited=  new boolean[n];
        pay = new int[n][2];
        max = 0;
        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            pay[i][0]=Integer.parseInt(st.nextToken());
            pay[i][1]=Integer.parseInt(st.nextToken());
        }

        recur(0);

        System.out.println(max);

    }

    static void recur(int cur){
        if(cur==n){
            int tmp = check();
            if(tmp==-1)return;
            max = Math.max(max,tmp);
            return;
        }

        visited[cur]=true;
        recur(cur+1);
        visited[cur]=false;
        recur(cur+1);


    }

    static int check(){
        job = new int[n];
        int sum = 0;
        for(int i=0;i<n;i++){
            if(!visited[i])continue;
            for(int j=0;j<pay[i][0];j++){
                if(i+j>=n)return -1;
                job[i+j]++;
            }
            sum +=pay[i][1];
        }
        for(int i=0;i<n;i++){
            if(job[i]>=2)return -1;
        }
        return sum;
    }




}