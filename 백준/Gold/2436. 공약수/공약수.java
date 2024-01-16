import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int gcd = Integer.parseInt(st.nextToken());
        int lcm = Integer.parseInt(st.nextToken());

        int c = lcm/gcd;

        int a = 1;
        int b =c;
        int  min = Integer.MAX_VALUE;
        for(int i=2;i<=Math.sqrt(c);i++){
               if(c%i==0){
                   int tmp = c/i + i;
                   if(min>tmp&&getGCD(i,c/i)==1){
                       min = tmp;
                        a = i;
                        b =c/a;
                   }
               }
        }

        System.out.println(a*gcd+" "+b*gcd);



    }


    static int getGCD(int x, int y){
        while (y!=0){
            int tmp = x%y;
            x=y;
            y=tmp;
        }
        return x;
    }

}