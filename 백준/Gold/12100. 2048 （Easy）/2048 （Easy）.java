import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int n,max;
    static int[][] arr;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        max = 2;
        StringTokenizer st;
        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<n;j++){
                arr[i][j]=Integer.parseInt(st.nextToken());
            }
        }
        recur(0,arr);

        System.out.println(max);



    }

    static void recur(int cur,int[][] board){
        if(cur==5){

//            for(int i=0;i<n;i++){
//                for(int j=0;j<n;j++){
//                    System.out.print(board[i][j]+" ");
//                }
//                System.out.println();
//            }
//            System.out.println();
            max = Math.max(max,getMax(board));
            return;
        }

        for(int i=0;i<4;i++){
//            System.out.println(cur+" "+i);
            recur(cur+1,move(board,i));
        }

    }


    static int[][] move(int[][] board,int d){
        int[][] moveArr = new int[n][n];
        int [] bf;
        if(d==0){
            for(int i=0;i<n;i++){
                bf= new int[n];
                int idx =0;
                int now =0;
                for(int j=0;j<n;j++){
                    if(now==0){
                        now=board[j][i];
                    } else if (board[j][i]==now) {
                        bf[idx++]=2*now;
                        now =0;
                    }else if(board[j][i]!=0&&board[j][i]!=now){
                        bf[idx++]=now;
                        now = board[j][i];
                    }
                    if(j==n-1)bf[idx++]=now;
                }
                for(int j=0;j<n;j++){
                    moveArr[j][i]=bf[j];
                }
            }
        } else if (d==1) {
            for(int i=0;i<n;i++){
                bf= new int[n];
                int idx =0;
                int now =0;
                for(int j=n-1;j>=0;j--){
                    if(now==0){
                        now=board[i][j];
                    } else if (board[i][j]==now) {
                        bf[idx++]=2*now;
                        now =0;
                    }else if(board[i][j]!=0&&board[i][j]!=now){
                        bf[idx++]=now;
                        now = board[i][j];
                    }
                    if(j==0)bf[idx++]=now;
                }
                for(int j=n-1;j>=0;j--){
                    moveArr[i][j]=bf[n-j-1];
                }

            }
        } else if (d==2) {
            for(int i=0;i<n;i++){
                bf= new int[n];
                int idx =0;
                int now =0;
                for(int j=n-1;j>=0;j--){
                    if(now==0){
                        now=board[j][i];
                    } else if (board[j][i]==now) {
                        bf[idx++]=2*now;
                        now =0;
                    }else if(board[j][i]!=0&&board[j][i]!=now){
                        bf[idx++]=now;
                        now = board[j][i];
                    }
                    if(j==0)bf[idx++]=now;
                }
                for(int j=n-1;j>=0;j--){
                    moveArr[j][i]=bf[n-1-j];
                }

            }
        } else {
            for(int i=0;i<n;i++){
                bf= new int[n];
                int idx =0;
                int now =0;
                for(int j=0;j<n;j++){
                    if(now==0){
                        now=board[i][j];
                    } else if (board[i][j]==now) {
                        bf[idx++]=2*now;
                        now =0;
                    }else if(board[i][j]!=0&&board[i][j]!=now){
                        bf[idx++]=now;
                        now = board[i][j];
                    }
                    if(j==n-1)bf[idx++]=now;
                }
                for(int j=0;j<n;j++){
                    moveArr[i][j]=bf[j];
                }
            }
        }


        return moveArr;
    }

    static int getMax(int[][] board){
        int x=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(board[i][j]>x)x=board[i][j];
            }
        }
        return x;
    }


}