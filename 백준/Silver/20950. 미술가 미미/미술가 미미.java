import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {


    static int n,min;
    static int[][] arr;
    static int[] gom;


    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        min = Integer.MAX_VALUE;
        n = Integer.parseInt(br.readLine());
        StringTokenizer st ;
        arr = new int[n][3];
        gom = new int[3];

        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<3;j++){
                arr[i][j]=Integer.parseInt(st.nextToken());
            }
        }
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<3;i++)gom[i]=Integer.parseInt(st.nextToken());

        recur(0,0,0,0,0);

        System.out.println(min);

    }

    static void recur(int cur,int cnt,int r, int g, int b){
        if(cnt>7)return;
        if(cur==n){
            if(cnt<2)return;
            min = Math.min(min,check(r,g,b,cnt));
            return;
        }
        recur(cur+1,cnt+1,r+arr[cur][0],g+arr[cur][1],b+arr[cur][2]);
        recur(cur+1,cnt,r,g,b);
    }

    static int check(int r,int g,int b,int cnt){
        return Math.abs(r/cnt-gom[0])+Math.abs(g/cnt-gom[1])+Math.abs(b/cnt-gom[2]);
    }



}