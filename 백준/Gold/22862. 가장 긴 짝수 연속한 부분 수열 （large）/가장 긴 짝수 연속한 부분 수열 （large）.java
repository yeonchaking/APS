import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N  = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[]arr = new int[N];
        st =  new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            arr[i] =Integer.parseInt(st.nextToken());
        }
        int s1 = 0;
        int s2 = 0;
        int cnt =0;
        int len =0;
        int max = 0;
        if(arr[s2]%2!=0)cnt++;
        else len++;
        while(s2<N){
            if(max<len){
                max = len;
            }
            if(cnt<=K){
                s2++;
                if(s2<N&&arr[s2]%2==0){
                    len++;
                }else if(s2==N) {
                    if(max<len){
                        max = len;
                    }
                    break;
                }else {
                     cnt++;
                }

//                System.out.println("s2증가"+s1+" "+s2+" 홀수는 "+cnt+"개 있고 길이는"+len);
            }else {
                if(arr[s1]%2==0){
                    len--;
                }else {
                    cnt--;
                }
                s1++;
//                System.out.println("s1증가"+s1+" "+s2+" 홀수는 "+cnt+"개 있고 길이는"+len);
            }
        }


        System.out.println(max);



    }





}