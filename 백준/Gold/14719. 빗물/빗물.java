import javax.swing.border.SoftBevelBorder;
import java.io.*;
import java.util.*;

public class Main {




    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int h = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());

         int [] width = new int[w];
         int [] leftPrefix = new int[w];
         int [] rightPrefix = new int[w];
         for(int i=0;i<w;i++){
             width[i]=Integer.parseInt(st.nextToken());
         }

         leftPrefix[0]=width[0];
         rightPrefix[w-1]=width[w-1];
         for(int i=1;i<w;i++){
             leftPrefix[i]=Math.max(width[i],leftPrefix[i-1]);
         }
        for(int i=w-2;i>=0;i--){
            rightPrefix[i]=Math.max(width[i],rightPrefix[i+1]);
        }

        int sum= 0;

        for(int i=0;i<w;i++){
            int tmp =Math.min(leftPrefix[i],rightPrefix[i])-width[i];
            if(tmp>0)sum+=tmp;
        }
        System.out.println(sum);







    }
}