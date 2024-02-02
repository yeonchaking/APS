import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int [] arr =new int[n];
        for(int i=0;i<n;i++){
            arr[i]=Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        StringBuilder sb = new StringBuilder();

        outer : for(int i=0;i<m;i++){
            int num = Integer.parseInt(st.nextToken());
//            System.out.println("---------------------"+num);
            int left = 0;
            int right = n-1;
            int mid;
            while (left-1<right){
                mid = (left+ right)/2;
//                System.out.println(arr[mid]);
                if(num==arr[mid]){
                    sb.append("1 ");
                    continue outer;
                }else if(num>arr[mid]){
                    left=mid+1;
                }else if(num < arr[mid]){
                    right=mid-1;
                }
            }
            sb.append("0 ");
        }

        System.out.println(sb.toString());

    }
}
