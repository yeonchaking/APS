import javax.swing.border.SoftBevelBorder;
import java.io.*;
import java.util.*;

public class Main {




    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int[] prefix = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i =0;i<n;i++){
            arr[i]=Integer.parseInt(st.nextToken());
            if(i==0){
                prefix[i]=0;
            }else {
                prefix[i]=arr[i]-arr[i-1];
            }
        }

        boolean perfect = true;
        int cnt =0;
        for(int i=1;i<n;i++){
            if(prefix[i]<0) {
                perfect = false;
                cnt++;
            }
        }

//        System.out.println(Arrays.toString(prefix));
        if(perfect){
            System.out.println(n);
//            System.out.println("정렬");
            return;
        }else if(cnt>1){
            System.out.println(0);
//            System.out.println("없음");
            return;
        } else if (n==2) {
            System.out.println(2);
            return;
        }
        int answer = 0;


        for(int i=2;i<n-1;i++){
            if(prefix[i]<0){
                if(prefix[i]+prefix[i-1]>=0)answer++;
                if(prefix[i]+prefix[i+1]>=0)answer++;
            }
        }
//        System.out.println(answer);


        if(prefix[1]<0){
            if(arr[0]>arr[2]){
//                System.out.println("ㅎㅇ1");
                answer=1;
            }else {
                answer=2;
            }
        }

        if(prefix[n-1]<0){
            if(arr[n-1]>=arr[n-3]){
                answer=2;
            }else {
//                System.out.println("ㅎㅇ2");
              answer=1;
            }
        }



        System.out.println(answer);
    }
}