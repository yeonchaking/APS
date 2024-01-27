
import javax.swing.border.SoftBevelBorder;
import java.io.*;
import java.util.*;

public class Main {




    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        int[] prefix = new int[n];

        for(int i=0;i<n;i++){
            arr[i]=Integer.parseInt(st.nextToken());
            if(i==0){
                prefix[i]=arr[i];
            }else {
                prefix[i]=arr[i]+prefix[i-1];
            }
        }

        int min = Integer.MAX_VALUE;
        int result = Integer.MIN_VALUE;;
        int tmp;
        for(int i=0;i<n;i++){
            if (i==0){
                min = 0;
            }else {
                min  = Math.min(min,prefix[i-1]);
            }
            tmp = prefix[i]-min;
            result = Math.max(tmp,result);
        }

        System.out.println(result);





    }
}