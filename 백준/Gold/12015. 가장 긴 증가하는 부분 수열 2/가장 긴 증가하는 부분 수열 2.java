import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {


    static int n,idx;
    static int[]arr;
    static int[] LIS;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
           arr[i]=Integer.parseInt(st.nextToken());
        }
        LIS = new int[n+1];
        idx= 0;
        for(int i=0;i<n;i++){
            if(arr[i]>LIS[idx]){
                idx++;
                LIS[idx]=arr[i];
            }else {
                int reIdx = BinarySearch(arr[i]);
                LIS[reIdx]=arr[i];
            }
        }
//        System.out.println(Arrays.toString(LIS));
        System.out.println(idx);




    }

    static int BinarySearch(int x){
        int left = 0;
        int right = idx;
        while(left<right){
            int mid = (left+right)/2;
            if(LIS[mid]<x){
                left=mid+1;
            }else {
                right=mid;
            }
        }
        return left;

    }


}