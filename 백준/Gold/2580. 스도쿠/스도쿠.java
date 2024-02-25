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
    static boolean done;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st ;
        sudoku = new int[9][9];
        visited = new boolean[9][9];
        sb = new StringBuilder();
        w = new boolean[9][10];
        h = new boolean[9][10];
        sq= new boolean[3][3][10];
        done= false;

        for(int i=0;i<9;i++){
            st = new StringTokenizer(br.readLine());
            for (int j=0;j<9;j++){
                sudoku[i][j]=Integer.parseInt(st.nextToken());
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
        if(done)return;
        if(y==9){
            y=0;
            x++;

        }
        if(x==9){
//            if (!check())return;
//            System.out.println("gd");
            for(int i=0;i<9;i++){
                for(int j=0;j<9;j++){
                    sb.append(sudoku[i][j]).append(" ");
                }
                sb.append("\n");
            }
            System.out.println(sb.toString());
            done=true;
            return;
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

    static boolean check(){

        System.out.println("------------------");
        System.out.println(Arrays.deepToString(sudoku));
        boolean[] check ;
        for(int k=0;k<=6;k+=3) {
            for(int l=0;l<=6;l+=3) {
                check = new boolean[10];
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        if(sudoku[k+i][l+j]==0)return false;
                        if(check[sudoku[k+i][l+j]])return false;
                        check[sudoku[k+i][l+j]]=true;
                    }
                }
            }
        }

        return true;

    }






}