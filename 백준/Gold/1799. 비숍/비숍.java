import javax.print.DocFlavor;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int n,max,max2;
    static int[][] chess;

    static boolean[] visited1;
    static boolean[] visited2;



    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        max =0;
        max2=0;
        chess = new int[n][n];
        visited1 = new boolean[2*n];
        visited2 = new boolean[2*n];
        StringTokenizer st;
        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<n;j++){
                chess[i][j]=Integer.parseInt(st.nextToken());
            }
        }
        recur(0,0,0);
        visited1 = new boolean[2*n];
        visited2 = new boolean[2*n];
        recur2(0,1,0);
        System.out.println(max+max2);
    }

    static void recur(int x,int y,int cnt){
        if(n%2==0){
            if(y==n+1){
                y=0;
                x++;
            }else if(y==n){
                y=1;
                x++;
            }
        }else {
            if(y==n+1){
                y=1;
                x++;
            }else if(y==n){
                y=0;
                x++;
            }
        }
        if(x==n){
            max = Math.max(cnt,max);
            return;
        }
        if(chess[x][y]==1&&check(x,y,cnt)) {
            visited1[x - y + n] = true;
            visited2[x + y] = true;
            recur(x, y + 2, cnt + 1);
            visited1[x - y + n] = false;
            visited2[x + y] = false;
            recur(x,y+2,cnt);
        }else {
            recur(x,y+2,cnt);
        }
    }

    static void recur2(int x,int y,int cnt){
        if(n%2==0){
            if(y==n+1){
                y=0;
                x++;
            }else if(y==n){
                y=1;
                x++;
            }
        }else {
            if(y==n+1){
                y=1;
                x++;
            }else if(y==n){
                y=0;
                x++;
            }
        }
        if(x==n){
            max2 = Math.max(cnt,max2);
            return;
        }
        if(chess[x][y]==1&&check(x,y,cnt)) {
            visited1[x - y + n] = true;
            visited2[x + y] = true;
            recur2(x, y + 2, cnt + 1);
            visited1[x - y + n] = false;
            visited2[x + y] = false;
            recur2(x,y+2,cnt);
        }else {
            recur2(x,y+2,cnt);
        }
    }

    static boolean check(int x, int y,int cnt){
        if(cnt==0)return true;
        return !visited1[x - y + n] && !visited2[x + y];

    }







}