import javax.swing.border.SoftBevelBorder;
import java.io.*;
import java.util.*;

public class Main {




    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());

        int[]height = new int[H];

        for(int i=0;i<N;i++){
            int tmp = Integer.parseInt(br.readLine());
            if(i%2==0){
                height[0]++;
                height[tmp]--;
            }else {
                height[H-tmp]++;
            }
        }

        int [] prefix = new int[H];
        prefix[0]=height[0];
        for(int i=1;i<H;i++){
            prefix[i]=prefix[i-1]+height[i];
        }
        int cnt =0;
        int min = Integer.MAX_VALUE;

        for(int i=0;i<H;i++){
            if(min>prefix[i]){
                cnt=1;
                min = prefix[i];
            } else if (min==prefix[i]) {
                cnt++;
            }
        }

        System.out.println(min+" "+cnt);





    }
}