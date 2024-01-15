import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        long a  = Long.parseLong(st.nextToken());
        long d  = Long.parseLong(st.nextToken());
        st = new StringTokenizer(br.readLine());
        long q = Long.parseLong(st.nextToken());

        StringBuilder sb = new StringBuilder();
        for(int t=0;t<q;t++){
            st = new StringTokenizer(br.readLine());
            long n =  Long.parseLong(st.nextToken());
            long l =  Long.parseLong(st.nextToken());
            long r =  Long.parseLong(st.nextToken());

            if(n==1) {
                long sum = 0;

                long len = r-l+1;
                if(len%2==1){
                    sum = (a+d*((r+l)/2-1))*len; // 중간값 * 길이
                }else {
                    sum = len * ((a + (l-1)*d)+(a + (r-1)*d)) /2; //l과r항의 평균 * 길이
                }
                sb.append(sum+"\n");

            }else {
                if(l==r){
                    sb.append(a+((l-1)*d)+"\n");
                }else {
                    sb.append(getGCD(a, d)+"\n");
                }
            }

        }
        System.out.println(sb.toString());

    }

    static long getGCD(long x,long y){
        while (y!=0){
            long tmp = y;
            y = x%y;
            x=tmp;
        }
        return x;
    }

}