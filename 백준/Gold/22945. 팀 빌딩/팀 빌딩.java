import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.security.spec.RSAOtherPrimeInfo;
import java.util.*;

public class Main {

    static int [] arr;
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
         arr = new int[n];

        for(int i=0;i<n;i++){
            arr[i]=Integer.parseInt(st.nextToken());
        }
        int s =0;
        int e = n-1;
        int max = Math.max(0, cal(s,e));
        while(s<e){
            int x = cal(s,e);
            if(max<x)max =x;
//            System.out.println(s+" "+e);
            if(arr[s]>arr[e]){
                e--;
            }else {
                s++;
            }
//            System.out.println(max);
        }

        System.out.println(max);
    }



    static int cal(int s, int e){
        return Math.min(arr[s],arr[e])*(e-s-1);
    }

}