import java.io.BufferedReader;
        import java.io.IOException;
        import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int n,k,max;
    static int[] can;
    static int[][] Range;
    static int[][] Merry;
    static int[] rResult;
    static int[] mResult;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        max = Integer.MIN_VALUE;
        can = new int[n];
        Range = new int[k][n];
        Merry = new int[k][n];
        rResult = new int[k];
        mResult = new int[k];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            can[i]=Integer.parseInt(st.nextToken());
        }

        for(int i=0;i<k;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<n;j++){
                Range[i][j]=Integer.parseInt(st.nextToken());
            }
        }
        for(int i=0;i<k;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<n;j++){
                Merry[i][j]=Integer.parseInt(st.nextToken());
            }
        }

        recur(0);
        System.out.println(max);
    }

    static void recur(int cur){

        if(cur==k){
//            System.out.println();
//            System.out.println(Arrays.toString(rResult));
//            System.out.println(Arrays.toString(mResult));
            int [] tmp = new int[n];
            for(int i=0;i<k;i++){
                tmp[rResult[i]]++;
                tmp[mResult[i]]++;
            }
            for(int i=0;i<n;i++){
                if(can[i]<tmp[i])return;
            } // 오바된거 없나 보고

            int sum = 0;
            // 이제 정산
            for(int i=0;i<k;i++){
                sum+=Range[i][rResult[i]];
                sum+=Merry[i][mResult[i]];
            }

            max = Math.max(max,sum);
            return;
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                rResult[cur]=i;
                mResult[cur]=j;
                recur(cur+1);
            }
        }



    }



}