import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {




    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int [] arr = new int[n];
        int [] prefix = new int[n];
        for(int i=0;i<n;i++){
            arr[i]=Integer.parseInt(st.nextToken());
            if(i==0)prefix[i]=arr[i];
            else prefix[i]=arr[i]+prefix[i-1];
        }

        int max = Integer.MIN_VALUE;
        int prefixLeft =0,prefixRight = 0;

        int min = Integer.MAX_VALUE;
        for(int i=0;i<n-1;i++){
            for(int j=i+1;j<n;j++){
//                System.out.println("-------------이번엔 "+i+" "+j);
                int s= i;
                int e =j;
                while(s<e){
                    int mid = (s+e)/2;
                    if(i==0)prefixLeft = prefix[mid];
                    else {
                        prefixLeft = prefix[mid]-prefix[i-1];
                    }
                        prefixRight = prefix[j]-prefix[mid];
                    if(min>Math.abs(prefixRight-prefixLeft)){
                        max = Integer.MIN_VALUE;
                        if(i==0)max = Math.max(max,prefix[j]);
                        else max =  Math.max(max,prefix[j]-prefix[i-1]);
                        min =Math.abs(prefixRight-prefixLeft);
                         } else if (min==Math.abs(prefixRight-prefixLeft)) {
                        if(i==0)max = Math.max(max,prefix[j]);
                        else max =  Math.max(max,prefix[j]-prefix[i-1]);
                        min =Math.abs(prefixRight-prefixLeft);
                    }
                    if(prefixLeft>prefixRight){
                            e=mid;
                        }else  {
                            s=mid+1;
                        }
                }
            }
        }

        System.out.println(max);

    }




}