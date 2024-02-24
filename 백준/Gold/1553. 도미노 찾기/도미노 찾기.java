import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int[][] arr;
    static boolean[][]visited;
    static boolean[] domino;
    static int count;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str ;
        domino = new boolean[67];
        arr = new int[8][7];
        visited = new boolean[8][7];
        for(int i=0;i<8;i++){
            str = br.readLine();
            for(int j=0;j<7;j++){
                arr[i][j]=str.charAt(j)-'0';
            }
        }

        recur(0,0,0);
        System.out.println(count);

    }

    static void recur(int x,int y,int cnt){
        if(cnt>28)return;
        if(y==7){
            y=0;
            x++;
        }
        if(x==8){
                if(cnt!=28){
                    return;
                }
                count++;
            return;
        }

        if(visited[x][y]){
            recur(x,y+1,cnt);
            return;
        }

        if(y<6){
            int num = Math.min(arr[x][y], arr[x][y+1]) * 10 + Math.max(arr[x][y], arr[x][y+1]);
            if(!domino[num] && !visited[x][y+1]){
                domino[num]=true;
                visited[x][y]=true;
                visited[x][y+1]=true;
                recur(x,y+1,cnt+1);
                visited[x][y]=false;
                visited[x][y+1]=false;
                domino[num]=false;
            }
        }
        if(x<7){
            int num = Math.min(arr[x][y], arr[x+1][y]) * 10 + Math.max(arr[x][y], arr[x+1][y]);
            if(!domino[num] && !visited[x+1][y]){
                domino[num]=true;
                visited[x][y]=true;
                visited[x+1][y]=true;
                recur(x,y+1,cnt+1);
                visited[x][y]=false;
                visited[x+1][y]=false;
                domino[num]=false;
            }
        }

    }





}