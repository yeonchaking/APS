import javax.swing.border.SoftBevelBorder;
import java.io.*;
import java.util.*;

public class Main {




    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] arr = new int[n][n];
        int[][] prefix = new int[n][n];

        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<n;j++){
                arr[i][j]=Integer.parseInt(st.nextToken());
                if(i==0&&j==0){
                    prefix[i][j]=arr[0][0];
                }else if(i==0){
                    prefix[i][j]=arr[i][j]+prefix[i][j-1];
                }else if(j==0){
                    prefix[i][j]=arr[i][j]+prefix[i-1][j];
                }else {
                    prefix[i][j]=arr[i][j]+prefix[i-1][j]+prefix[i][j-1]-prefix[i-1][j-1];
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int t =0;t<m;t++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken()) - 1;
            int y1 = Integer.parseInt(st.nextToken()) - 1;
            int x2 = Integer.parseInt(st.nextToken()) - 1;
            int y2 = Integer.parseInt(st.nextToken()) - 1;

            int result = prefix[x2][y2];
            if(x1==x2&&y1==y2){
                result=arr[x1][y1];
            }else if(x1==0&&y1!=0){
                result-=prefix[x2][y1-1];
            }else if(x1!=0&&y1==0){
                result-=prefix[x1-1][y2];
            }else if(x1>0&&y1>0) {
                result +=-prefix[x1-1][y2]-prefix[x2][y1-1]+prefix[x1-1][y1-1];
            }


            sb.append(result+"\n");
        }
        System.out.println(sb.toString());




    }
}