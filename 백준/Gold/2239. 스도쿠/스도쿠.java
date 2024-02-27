import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int[][] sudoku;
    static boolean[][] visited;
    static boolean[][] w;
    static boolean[][] h;
    static boolean[][][]sq;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st ;
        sudoku = new int[9][9];
        visited = new boolean[9][9];
        sb = new StringBuilder();
        w = new boolean[9][10];
        h = new boolean[9][10];
        sq= new boolean[3][3][10];
        String str = "";
        for(int i=0;i<9;i++){
            str = br.readLine();
//            st = new StringTokenizer(br.readLine());
            for (int j=0;j<9;j++){
                sudoku[i][j]=str.charAt(j)-'0';
//                sudoku[i][j]=Integer.parseInt(st.nextToken());
                if(sudoku[i][j]!=0){
                    visited[i][j]=true;
                    w[i][sudoku[i][j]]=true;
                    h[j][sudoku[i][j]]=true;
                    sq[i/3][j/3][sudoku[i][j]]=true;
                }
            }
        }

        recur(0,0);

    }

    static void recur(int x,int y){
        if(y==9){
            y=0;
            x++;

        }
        if(x==9){
            for(int i=0;i<9;i++){
                for(int j=0;j<9;j++){
                    sb.append(sudoku[i][j]);
                }
                sb.append("\n");
            }
            System.out.println(sb.toString());
            System.exit(0);
        }
        if(visited[x][y]){
            recur(x,y+1);
            return;
        }
        for(int i=1;i<=9;i++){
            if(w[x][i]||h[y][i]||sq[x/3][y/3][i])continue;
            visited[x][y]=true;
            w[x][i]=true;
            h[y][i]=true;
            sq[x/3][y/3][i]=true;
            sudoku[x][y]=i;
            recur(x,y+1);
            visited[x][y]=false;
            w[x][i]=false;
            h[y][i]=false;
            sq[x/3][y/3][i]=false;
            sudoku[x][y]=0;
        }
    }






}