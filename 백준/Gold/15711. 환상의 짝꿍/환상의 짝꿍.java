import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

//    static boolean isPrime(long x){
//        if(x==1)return false;
//        for(int i=2;i<=Math.sqrt(x);i++){
//            if(x%i==0)return false;
//        }
//        return true;
//    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder output = new StringBuilder();
        StringTokenizer st;
        int count =0;
        boolean [] isNotPrime = new boolean[2100000];
        isNotPrime[0]=true;
        isNotPrime[1]=true;
        for(int i=2;i<2100000;i++){
            if(isNotPrime[i])continue;
            for(int j=i;j<2100000;j+=i){
                if(j==i)continue;
                isNotPrime[j]=true;
            }
        }

        for(int i=2;i<2100000;i++){
            if(!isNotPrime[i])count++;
        }
        int []arr = new int[count];
        count=0;

        for(int i=2;i<2100000;i++){
            if(!isNotPrime[i]){
                arr[count++]=i;
            }
        }
        //이제 arr 엔 2백만까지의 소수들만 들어가있음



        outer : for(int tc = 1;tc<=T;tc++) {
            st = new StringTokenizer(br.readLine());
            long a = Long.parseLong(st.nextToken());
            long b = Long.parseLong(st.nextToken());
            long p = a+b;
            if(p==2||p==3){
                output.append("NO\n");
                continue ;
            }
            if(p%2==0){
                output.append("YES\n");
                continue ;
            }


            flag :for(long l : arr){
                if(p<=l){
                    break ;
                }
                for(long i : arr){
                    if((p-l)<=i)continue ;
                    if((p-l)%i==0){
                        continue flag;
                    }
                }
                output.append("YES\n");
                continue outer;
            }
            output.append("NO\n");


        }

        System.out.println(output.toString());
    }

}
