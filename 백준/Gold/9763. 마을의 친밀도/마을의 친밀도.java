import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int [][]arr;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        StringTokenizer st;

        arr = new int[n][3];
        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            arr[i][0]=Integer.parseInt(st.nextToken());
            arr[i][1]=Integer.parseInt(st.nextToken());
            arr[i][2]=Integer.parseInt(st.nextToken());
        }

        int min = Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            int min1 = Integer.MAX_VALUE; // 제일 짧은거
            int min2 = Integer.MAX_VALUE; // 두번째로 짧은거
            for(int j=0;j<n;j++){
                if(i==j)continue;
                int tmp = getLength(i,j);

                if(min1>tmp){
                    min2 = min1;
                    min1 = tmp;
                }else if(min2>tmp){
                    min2 = tmp;
                }
            }
            min = Math.min(min,min1+min2);
        }
        System.out.println(min);






    }


    static int getLength(int x, int y){
        return Math.abs(arr[x][0]-arr[y][0])+Math.abs(arr[x][1]-arr[y][1])+Math.abs(arr[x][2]-arr[y][2]);
    }

}