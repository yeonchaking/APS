import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Writer;
import java.util.*;

public class Main {

    static boolean[] light ;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[]arr = new int[9];
        int sum =0;
        for(int i=0;i<9;i++){
            arr[i]=Integer.parseInt(br.readLine());
            sum+=arr[i];
        }

        Arrays.sort(arr);

        int s =0;
        int e = 8;

        int spy = sum-100;

        while (s<e){
            int p = arr[s]+arr[e];
            if(p>spy){
                e--;
            } else if (p<spy) {
                s++;
            }else {
                for(int i=0;i<9;i++){
                    if(i==s||i==e)continue;
                    System.out.println(arr[i]);
                }
                return;
            }
        }


    }



}