import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int change = 1000-Integer.parseInt(br.readLine());
        int cnt = 0;
        int [] arr = {500,100,50,10,5,1};
        int idx=0;
        while(change>0){
            if(arr[idx]<change){
                change-=arr[idx];
                cnt++;
            }else if(arr[idx]==change){
                cnt++;
                break;
            }else {
                idx++;
            }
        }

        System.out.println(cnt);



    }

}