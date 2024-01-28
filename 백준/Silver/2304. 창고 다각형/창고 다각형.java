import javax.swing.border.SoftBevelBorder;
import java.io.*;
import java.util.*;

public class Main {




    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[][] q = new int[n][2];
        StringTokenizer st ;
        int maxIdx =0;
        for(int i=0;i<n;i++){
            st= new StringTokenizer(br.readLine());
            q[i][0]=Integer.parseInt(st.nextToken());
            q[i][1]=Integer.parseInt(st.nextToken());
            if(maxIdx<q[i][0])maxIdx=q[i][0];
        }
        int[] arr = new int[maxIdx+1];
        int[] LeftPrefix = new int[maxIdx+1];
        int[] RightPrefix = new int[maxIdx+1];

        for(int i=0;i<n;i++){
            arr[q[i][0]]=q[i][1];
        }
        LeftPrefix[0]=arr[0];
        RightPrefix[maxIdx]=arr[maxIdx];

        for(int i=1;i<=maxIdx;i++){
            LeftPrefix[i]=Math.max(arr[i],LeftPrefix[i-1]);
        }
        for(int i=maxIdx-1;i>0;i--){
            RightPrefix[i]=Math.max(arr[i],RightPrefix[i+1]);
        }
//        System.out.println(Arrays.toString(arr));
//        System.out.println(Arrays.toString(LeftPrefix));
//        System.out.println(Arrays.toString(RightPrefix));

        int sum = 0;
        for(int i=0;i<=maxIdx;i++){
            sum+=Math.min(LeftPrefix[i],RightPrefix[i]);
        }
        System.out.println(sum);
    }
}