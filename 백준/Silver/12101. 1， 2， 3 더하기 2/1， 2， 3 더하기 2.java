import java.io.BufferedReader;
        import java.io.IOException;
        import java.io.InputStreamReader;
import java.rmi.server.UID;
import java.security.spec.RSAOtherPrimeInfo;
        import java.util.*;

public class Main {

        static int n,k;
        static int cnt;
        static ArrayDeque<Integer> ad;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        cnt = 0;
        ad = new ArrayDeque<>();
        recur(0);

        if(cnt<k) System.out.println(-1);
    }

    static void recur(int cur){
        if(cur>n)return;
        else if (cur==n) {
            cnt++;
            StringBuilder sb = new StringBuilder();
            if(cnt==k){
                while (ad.size()!=1){
                    sb.append(ad.pollFirst()).append('+');
                }
                sb.append(ad.pollFirst());
                System.out.println(sb.toString());
            }
            return;
        }

        for(int i=1;i<=3;i++){
            ad.addLast(i);
            recur(cur+i);
            ad.pollLast();
        }

    }



}