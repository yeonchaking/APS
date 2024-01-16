import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        boolean[][] check = new boolean[1001][1001];

        for(int i=0;i<=1000;i++){
            for(int j=0;j<=1000;j++){
                if(getGCD(i,j)==1){
                    check[i][j]=true;
                }
            }
        }

        for (int tc = 1; tc <= T; tc++) {
                int cnt =0;
                int n = Integer.parseInt(br.readLine());

                for(int i=0;i<=n;i++){
                    for(int j=0;j<=n;j++){
                        if(check[i][j])cnt++;
                    }
                }
            System.out.println(cnt);
        }


    }
    static int getGCD(int x, int y){
        while (y!=0){
            int tmp = y;
         y = x%y;
         x= tmp;
        }
        return x;
    }

}