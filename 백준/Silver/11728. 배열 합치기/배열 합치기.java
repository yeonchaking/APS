import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Writer;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] arr1 = new int[n];
        int[] arr2 = new int[m];
        st = new StringTokenizer(br.readLine());
        for(int i = 0;i<n;i++){
            arr1[i]=Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for(int i = 0;i<m;i++){
            arr2[i]=Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr1);
        Arrays.sort(arr2);
        int s1 = 0,s2=0;
        int [] answer = new int[n+m];
        int idx=0;
        while (s1<n&&s2<m){
            if(arr1[s1]<arr2[s2]){
                answer[idx++]=arr1[s1];
                s1++;
            }else {
                answer[idx++]=arr2[s2];
                s2++;
            }
        }
        if(s1<n){
            while (s1<n){
                answer[idx++]=arr1[s1++];
            }
        }
        if(s2<m){
            while (s2<m){
                answer[idx++]=arr2[s2++];
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0;i<idx;i++){
            sb.append(answer[i]+" ");
        }

        System.out.println(sb.toString());
    }



}