import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
         boolean[] primeSet = new boolean[1000001];

         Arrays.fill(primeSet,true);
         primeSet[0]=false;
         primeSet[1]=false;
         for(int i=2;i<=1000000;i++){
            if(primeSet[i]){
                for(int j=i+i;j<=1000000;j+=i){
                    primeSet[j]=false;
                }
            }
         }

//        System.out.println(Arrays.toString(primeSet));
        for(int tc=1;tc<=T;tc++) {
            st = new StringTokenizer(br.readLine());
            long n = Long.parseLong(st.nextToken());
            long k = Long.parseLong(st.nextToken());

            HashMap<Long, Long> nMap = new HashMap<>();
            HashMap<Long, Long> kMap = new HashMap<>();



            // 일단 k를 먼저 소인수분해해보자
            // 소인수분해해서 kMap에 담아
            for(long i=2;i*i<=k;i++){

                if(primeSet[(int)i]){
                    while (k%i==0){
                        if(!kMap.containsKey(i)){
                            kMap.put(i,(long)1);
                        }else {
                            kMap.put(i,kMap.get(i)+1);
                        }
                        k/=i;
                    }
                }
            }
            if(k!=1){
                    kMap.put( k, (long) 1);
            }

            // kMap에 keyset을 뽑아
            Set<Long> ss= kMap.keySet();
            long [] prime = new long[ss.size()];

            int idx =0;
            for(long l : ss){
                if (l==1||l==0)continue;
                prime[idx++]=l;
            }




            // keySet 에 있는 소수만 n!에서 추출함
            for(long l : prime){
                if (l==1||l==0)continue;
                long co = 0;
                long num = n;

                while(num>1){
                    num/=l;
                    co+=num;
                }
                nMap.put(l,co);
            }
//            System.out.println(kMap);
//            System.out.println(nMap);

            // 각 소수에 대해서 nMap에서의 값이랑 kMap에서의 값 나눔
            // nMap값/kMap값의 최솟값은 충족시켜야 제곱할 수 있으니
            // min 값을 구해서 출력
            long min = Long.MAX_VALUE;

            long tmp;
            for(long l : prime){
                tmp = nMap.get(l)/kMap.get(l);
                min = Math.min(min, tmp);
            }
            System.out.println(min);
        }
    }

}