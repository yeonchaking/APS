import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {


    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        long n  = Long.parseLong(st.nextToken());
        long a  = Long.parseLong(st.nextToken());

        int cnt = 0;


        while (n>1){
            n/=a;
            cnt+=n;
        }

        System.out.println(cnt);
    }



}