import java.awt.image.RasterOp;
import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] arr = new int[N][M];
        int[][] prefix = new int[N][M];
        HashSet<Integer> rSet = new HashSet<>();
        boolean [] c = new boolean[334];
        rSet.add(0);
        rSet.add(N-1);
        c[0]=true;
        c[M-1]=true;
        for(int i=0;i<N;i++){
            String str = br.readLine();
            for(int j=0;j<M;j++){
                arr[i][j]=str.charAt(j)-'0';
                if(arr[i][j]==1){
//                    System.out.println(i+" "+j);
                if(i>0)rSet.add(i-1);
                if(i<N-1)rSet.add(i+1);
                if(j>0)c[j-1]=true;
                if(j<M-1)c[j+1]=true;
                }
            }
        }

        prefix[0][0]=arr[0][0];
        for(int i=1;i<N;i++){
            prefix[i][0]=arr[i][0]+prefix[i-1][0];
        }
        for(int i=1;i<M;i++){
            prefix[0][i]=arr[0][i]+prefix[0][i-1];
        }

        for(int i=1;i<N;i++){
            for(int j=1;j<M;j++){
                prefix[i][j]=arr[i][j]+prefix[i-1][j]+prefix[i][j-1]-prefix[i-1][j-1];
            }
        }
//        System.out.println(rSet);
//        System.out.println(cSet);

        int max =0;
        int prefixSum = 0;
        int s = 0,e=0;
        int idx = 0;
        int size = 0;
        for(int i=0;i<334;i++){
            if(c[i])size++;
        }
        int[] cArray = new int[size];
        for(int i=0;i<334;i++){
            if(c[i])cArray[idx++]=i;
        }
        for(int x1 : rSet){
            for(int x2 : rSet){
                if(x2<x1)continue;
//                System.out.println(x1+" "+x2);
                s=0;
                e=0;
                 while(e<size) {
                     int y1 = cArray[s];
                     int y2 = cArray[e];
//                     System.out.println(x1+" "+y1+" "+x2+" "+y2);
                     if (x1 == 0 && y1 == 0) {
                         prefixSum = prefix[x2][y2];
                     } else if (x1 == 0) {
                         prefixSum = prefix[x2][y2] - prefix[x2][y1 - 1];
                     } else if (y1 == 0) {
                         prefixSum = prefix[x2][y2] - prefix[x1 - 1][y2];
                     } else {
//                            System.out.println(x1+" "+y1+" "+x2+" "+y2);
                         prefixSum = prefix[x2][y2] - prefix[x1 - 1][y2] - prefix[x2][y1 - 1] + prefix[x1 - 1][y1 - 1];
                     }
                     if (prefixSum != 0) {
                         s++;
                         if(s>e)e++;
                     } else {
                         e++;
                     }
                     int area = (x2-x1+1)*(y2-y1+1);
                     if(prefixSum==0&&max<area){
                         max=area;
                     }
                 }
            }
        }

        System.out.println(max);



    }
}