import java.io.*;
import java.util.*;

public class Main {


    static int N,d,k,c ;
    static int[] sushi,sushiCnt;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N  = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        sushi  = new int[N];
        sushiCnt= new int[d];
        for(int i=0;i<N;i++){
            sushi[i]=Integer.parseInt(br.readLine());
        }


        int s = 0,e=k-1,cnt = 0,max=0;
        //처음에 일단 한바퀴 돌아서 cnt하자

        sushiCnt[c-1]++;
        cnt++;
        for(int i=s;i<=e;i++){
            if(sushiCnt[sushi[i]-1]==0)cnt++;
            sushiCnt[sushi[i]-1]++;
        }
        s++;
        e++;
//        System.out.println(Arrays.toString(sushiCnt));

        while (s<N){
            if(max<cnt)max=cnt;
//            System.out.println(s+" "+e+" "+cnt+" => "+max);

            if(e==N){
                e=0;
            }


            // 옮겨가서 먹기
            if(sushiCnt[sushi[e]-1]==0)cnt++;
            sushiCnt[sushi[e]-1]++;

            // 그 전에 있던자리 복구하기


            if(s==0){
                sushiCnt[sushi[N-1]-1]--;
                if(sushiCnt[sushi[N-1]-1]==0)cnt--;
            }else {
                sushiCnt[sushi[s-1]-1]--;
                if(sushiCnt[sushi[s-1]-1]==0)cnt--;
            }
//            System.out.println(Arrays.toString(sushiCnt));
            s++;
            e++;
        }
        int last =0;
        for(int i=0;i<d;i++){
            if(sushiCnt[i]>0)last++;
        }
        if(last>max)max =last;


        System.out.println(max);
    }


}