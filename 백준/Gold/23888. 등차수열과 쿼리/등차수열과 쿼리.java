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

        for(int t=0;t<q;t++){
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());

            if(n==1) {
                long sum = 0;

                int len = r-l+1;
                if(len%2==1){
                    sum = (a+d*((r+l)/2-1))*len; // 중간값 * 길이
                }else {
                    sum = len * ((a + (l-1)*d)+(a + (r-1)*d)) /2; //l과r항의 평균 * 길이
                }
                System.out.println(sum);

            }else {
                if(l==r){
                    System.out.println(a+((l-1)*d));
                }else {
                    System.out.println(getGCD(a, d));
                }
            }

        }


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