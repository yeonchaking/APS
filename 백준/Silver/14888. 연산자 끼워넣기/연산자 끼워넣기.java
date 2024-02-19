import java.io.BufferedReader;
        import java.io.IOException;
        import java.io.InputStreamReader;
import java.rmi.server.UID;
import java.security.spec.RSAOtherPrimeInfo;
        import java.util.*;

public class Main {

        static int n;
        static int[] arr;
        static int[] oper;
        static int[] result;
        static int min, max;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        result = new int[n-1];
        oper = new int[4];
        min = Integer.MAX_VALUE;
        max = Integer.MIN_VALUE;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            arr[i]=Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<4;i++){
            oper[i]=Integer.parseInt(st.nextToken());
        }

        recur(0);

        System.out.println(max);
        System.out.println(min);

    }

    static void recur(int cur){

        if(cur==n-1){
            int [] tmp = {0,0,0,0};
            for(int i=0;i<n-1;i++){
                tmp[result[i]]++;
            }

            for(int i=0;i<4;i++)if(oper[i]!=tmp[i])return;

            int num = arr[0];
            for(int i=0;i<n-1;i++){
                if(result[i]==0){
                    num+=arr[i+1];
                }else if(result[i]==1){
                    num-=arr[i+1];
                } else if (result[i]==2) {
                    num*=arr[i+1];
                }else {
                    num/=arr[i+1];
                }
            }
            max = Math.max(max,num);
            min = Math.min(min,num);
            return;
        }

        for(int i=0;i<4;i++){
            result[cur]=i;
            recur(cur+1);
        }



    }



}