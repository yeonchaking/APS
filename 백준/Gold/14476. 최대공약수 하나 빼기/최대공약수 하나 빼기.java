import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static boolean[] isPrime;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        long [] arr = new long[N];
        isPrime= new boolean[200000];
        Arrays.fill(isPrime,true);
        isPrime[0]=false;
        isPrime[1]=false;
        for(int i=2;i<200000;i++){
            if(isPrime[i]){
                for(int j=i+i;j<200000;j+=i){
                    isPrime[j]=false;
                }
            }
        }
        st= new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            arr[i]=Long.parseLong(st.nextToken());
        }
        long a = arr[0];
        ArrayList<Long> list = new ArrayList<>();
        for(long i=2;i<=Math.sqrt(a);i++){
            if(a%i==0) {
                list.add(i);
                list.add(a/i);
            }
        }
        list.add(a);

        long gcd = -1;
        int exIdx = 0;
        boolean first = false;
        gcd = getGCD(arr[1],arr[2]);

        for(int i=3;i<N;i++){
            gcd = getGCD(gcd,arr[i]);
        }
        if(arr[0]%gcd==0){
            first=true;
            gcd = -1;
        } // 트루면 0번째는 답이 될 수 없다는뜻 -제외되지 않음 gcd 초기화하자
        // 펄스면? gcd에 그냥 넣어놔~


        // 약수만 돌아보면서
        outer : for(long i : list){
            int cnt =0;
            int idx = -1;
            for(int j=1;j<N;j++){
                if(arr[j]%i!=0){
                    cnt++;
                    idx=j;
                }
                if(cnt>1)continue outer;
            }
            if(cnt==1) {
                gcd = Math.max(gcd, i);
                exIdx=idx;
            }
        }

        if(gcd==-1){
            System.out.println(-1);
        }else {
            System.out.println(gcd+" "+arr[exIdx]);
        }



    }


    static long getGCD(long x,long y){
        while(y!=0){
            long tmp = x%y;
            x = y;
            y = tmp;
        }
        return x;
    }



}