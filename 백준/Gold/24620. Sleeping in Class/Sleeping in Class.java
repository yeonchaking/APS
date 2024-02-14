import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.security.spec.RSAOtherPrimeInfo;
import java.util.*;

public class Main {

    static int n;
    static int [] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        TestCase : for(int tc=1;tc<=T;tc++){
            n = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            arr = new int[n];
            int prefixSum=0;
            for(int i=0;i<n;i++){
                arr[i]=Integer.parseInt(st.nextToken());
                prefixSum+=arr[i];
            }

            if(prefixSum==0){
                sb.append(0).append("\n");
                continue TestCase;
            }
            TreeSet<Integer> set = new TreeSet<>();
            set.add(1);
            set.add(prefixSum);
            for(int i=2;i<=Math.sqrt(prefixSum);i++){
                if(prefixSum%i==0){
                    set.add(i);
                    set.add(prefixSum/i);
                }
            }

            for(int i : set){
                if(i==0)continue ;
                if(check(i,prefixSum)){
                    sb.append((n - prefixSum / i)).append("\n");
                    continue TestCase;
                }

            }


        }
        System.out.println(sb.toString());

    }

    static boolean check(int x,int prefixSum){
        int sum = 0;
        int cnt =0;
        for(int i=0;i<n;i++){
            sum+=arr[i];

            if(sum>x)return false;
            else if(sum==x){
                sum=0;
                cnt++;
            }
        }
        if(sum==0&&x*cnt==prefixSum)return true;
        else return false;
    }



}