import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int tc = 1;tc<=T;tc++){
            int n = Integer.parseInt(br.readLine());
            int [][] arr = new int[n][2];
            StringTokenizer st;
            for(int i=0;i<n;i++){
                st = new StringTokenizer(br.readLine());
                arr[i][0]=Integer.parseInt(st.nextToken());
                arr[i][1]=Integer.parseInt(st.nextToken());
            }
            Arrays.sort(arr, Comparator.comparingInt(o1 -> o1[0]));
            int[] dp = new int[n];

            Arrays.fill(dp,1);

            int max =n;
            int now =arr[0][1];
            for(int i=0;i<n;i++){
                if(arr[i][1]>now)max--;
                else if(arr[i][1]<now)now=arr[i][1];
            }
            sb.append(max+"\n");
        }
        System.out.println(sb.toString());

    }


}