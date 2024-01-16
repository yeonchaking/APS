import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long N = Long.parseLong(br.readLine());

        int cnt =0;
        long l=1;
        while (l*l<N){
            cnt++;
            l++;
        }
        if(N==1){
            System.out.println(1);
        }else {
            System.out.println(cnt);
        }


    }

}