import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int n,m,min,idx,len;
    static int[] key;


    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str =br.readLine();
        len = str.length();
        n = Integer.parseInt(str);
        int f = Integer.parseInt(br.readLine());
        StringTokenizer st ;
        HashSet<Integer> set = new HashSet<>();
        key = new int[10-f];
        min = Math.abs(n-100);
        if(f!=0){
            st= new StringTokenizer(br.readLine());
            for(int i =0;i<f;i++){
                set.add(Integer.parseInt(st.nextToken()));
            }
        }
        idx=0;
        for(int i=0;i<10;i++){
            if(set.contains(i))continue;
            key[idx++]=i;
        }


        if(f==0) {
            System.out.println(Math.min(len,min));
        }else {
            recur(0,0);
            System.out.println(min);
        }


    }

    static void recur(int cur,int num){
        if(cur==len){
            if(len>1)min = Math.min(min,cur-1+Math.abs(num/10-n));
            min = Math.min(min,cur+Math.abs(num-n));
            for(int i=0;i<idx;i++){
                min = Math.min(min,cur+1+Math.abs(num*10+key[i]-n));
            }

            return;
        }


        for(int i=0;i<idx;i++){
            if(cur==0)recur(cur+1,key[i]);
            else {recur(cur+1,num*10+key[i]);
            recur(cur+1,num);}
        }

    }





}