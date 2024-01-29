import java.awt.image.RasterOp;
import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {

    static int[][] prefix;
    static int[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int [][] arr = new int[N][N];
        int [][][]cntArr = new int[N][N][11];
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                arr[i][j]=Integer.parseInt(st.nextToken());
            }
        }
        cntArr[0][0][arr[0][0]]++;
        for(int i=1;i<N;i++){
            cntArr[0][i][arr[0][i]]++;
            for(int j=1;j<=10;j++){
                cntArr[0][i][j]+=cntArr[0][i-1][j];
            }
        }
        for(int i=1;i<N;i++){
            cntArr[i][0][arr[i][0]]++;
            for(int j=1;j<=10;j++){
                cntArr[i][0][j]+=cntArr[i-1][0][j];
            }
        }

        for(int i=1;i<N;i++){
            for(int j=1;j<N;j++){
                cntArr[i][j][arr[i][j]]++;
                for(int k=1;k<=10;k++){
                    cntArr[i][j][k]+=cntArr[i-1][j][k]+cntArr[i][j-1][k]-cntArr[i-1][j-1][k];
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        int Q  = Integer.parseInt(br.readLine());
        for(int q =1;q<=Q;q++){
            st = new StringTokenizer(br.readLine());
            int x1 =Integer.parseInt(st.nextToken())-1;
            int y1 =Integer.parseInt(st.nextToken())-1;
            int x2 =Integer.parseInt(st.nextToken())-1;
            int y2 =Integer.parseInt(st.nextToken())-1;

            int cnt =0;

            int [] check = new int[11];


            if(x1==0&&y1==0){
                for(int i=1;i<=10;i++){
                    check[i]=cntArr[x2][y2][i];
                }
            } else if (x1!=0&&y1==0) {
                for(int i=1;i<=10;i++){
                    check[i]=cntArr[x2][y2][i]-cntArr[x1-1][y2][i];
                }
            } else if (x1==0&&y1!=0) {
                for(int i=1;i<=10;i++){
                    check[i]=cntArr[x2][y2][i]-cntArr[x2][y1-1][i];
                }
            }else {
                for(int i=1;i<=10;i++){
                    check[i]=cntArr[x2][y2][i]-cntArr[x2][y1-1][i]-cntArr[x1-1][y2][i]+cntArr[x1-1][y1-1][i];
                }
            }
            for(int i=1;i<=10;i++){
                if(check[i]!=0)cnt++;
            }
            sb.append(cnt+"\n");


        }
        System.out.println(sb.toString());


    }



}