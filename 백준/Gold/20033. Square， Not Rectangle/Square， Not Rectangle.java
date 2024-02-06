import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int [] arr;
    static Stack<Integer> stack ;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new int[N];
        stack = new Stack<>();
        int max = 0;
        for(int i=0;i<N;i++){
            arr[i]=Integer.parseInt(st.nextToken());
            if(max<arr[i])max=arr[i];
        }

        int low =1;
        int high =N+1;
        int mid = (high+low)/2;
//        System.out.println(low+" "+high+" "+mid);
        while(low<high){
            mid = (high+low)/2;

            if(square(mid)){
                low = mid+1;
            }else {
                high=mid;
            }
//            System.out.println(low+" "+high+" "+mid);
        }

        System.out.println(low-1);







    }

    static boolean square(int x){
        stack.clear();
        for(int i=0;i<arr.length;i++){
         if(arr[i]>=x){
             stack.add(i);
         }else {
             stack.clear();
         }
         if(stack.size()>=x){
             return true;
         }
        }
        return false;
    }


}