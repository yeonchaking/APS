import java.io.*;
import java.util.*;

public class Main {




    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st ;
        int [] A = new int[N];
        int [] B = new int[N];
        int [] C = new int[N];
        int [] D = new int[N];

        int [] AB = new int[N*N];
        int [] CD = new int[N*N];

        for(int i=0;i<N;i++){
            st =new StringTokenizer(br.readLine());
            A[i]=Integer.parseInt(st.nextToken());
            B[i]=Integer.parseInt(st.nextToken());
            C[i]=Integer.parseInt(st.nextToken());
            D[i]=Integer.parseInt(st.nextToken());
        }

        int idx = 0;
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                AB[idx++]=A[i]+B[j];
            }
        }

        idx = 0;
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                CD[idx++]=C[i]+D[j];
            }
        }

        Arrays.sort(AB);
        Arrays.sort(CD);
        int s = 0;
        int e = N*N-1;
        long cnt =0;
//        System.out.println(Arrays.toString(AB));
//        System.out.println(Arrays.toString(CD));

        int sum =0;
        while (s<N*N&&e>=0){
//            System.out.println(s+" "+e);
            sum = AB[s]+CD[e];

            if(sum>0){
                e--;
            }else if(sum<0){
                s++;
            }else {
                int x =s;
                int y =e;
                while (x<N*N&&AB[x]==AB[s]){
                    x++;
                }
                while (y>=0&&CD[y]==CD[e]){
                    y--;
                }
                cnt+= (long) (x - s) *(e-y);
                s = x;
                e = y;
            }
        }
//        System.out.println(s+" "+e);
        System.out.println(cnt);

    }
}