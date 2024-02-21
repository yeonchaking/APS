import java.io.BufferedReader;
        import java.io.IOException;
        import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {


    static int n, m,h,c,result;
    static int[][] arr;

    static int[][] bbq;
    static int[][] home;
    static boolean[] visited;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n][n];
        h=0;
        c=0;
        result = Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            st =new StringTokenizer(br.readLine());
            for(int j=0;j<n;j++){
                arr[i][j]=Integer.parseInt(st.nextToken());
                if(arr[i][j]==1)h++;
                if(arr[i][j]==2)c++;
            }
        }
        bbq= new int[c][2];
        visited = new boolean[c];
        home = new int[h][2];
        int cIdx = 0;
        int hIdx = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(arr[i][j]==1){
                    home[hIdx][0]=i;
                    home[hIdx][1]=j;
                    hIdx++;
                }else if(arr[i][j]==2){
                    bbq[cIdx][0]=i;
                    bbq[cIdx][1]=j;
                    cIdx++;
                }
            }
        }

        recur(0,0);
        System.out.println(result);
    }

    static void recur(int cur,int cnt){
        if(cur==c){
            if(cnt>m)return;
            result= Math.min(result,getChickenLength());
            return;
        }

        visited[cur]=true;
        recur(cur+1,cnt+1);
        visited[cur]=false;
        recur(cur+1,cnt);
    }


    static int getChickenLength(){
        int len = 0;
        for(int i=0;i<h;i++){
            int tmp = 100;
            for(int j=0;j<c;j++){
                if(!visited[j])continue;
                tmp = Math.min(tmp,getLength(i,j));
            }
            len+=tmp;
        }
        return len;
    }

    static int getLength(int h,int c){
        return Math.abs(home[h][0]-bbq[c][0])+Math.abs(home[h][1]-bbq[c][1]);
    }
}