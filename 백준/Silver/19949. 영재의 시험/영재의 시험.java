import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {


    static int cnt,n;

    static int[] result;
    static int[] answer;

    static int tmp;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int idx =0;
        ArrayList<Integer> list = new ArrayList<>();
        while (st.hasMoreTokens()){
            list.add(Integer.parseInt(st.nextToken()));
        }
        n = list.size();
        result = new int[n];
        answer = new int[n];
        for(int i : list){
            answer[idx++]= i;
        }

        tmp = 0;
        recur(0);
        System.out.println(cnt);

    }

    static void recur(int cur){
        if(cur==n){
            if(check())cnt++;

            return;
        }

        for(int i=1;i<=5;i++){
            result[cur]=i;
            recur(cur+1);
        }

    }

    static boolean check(){
        int ans =0;
        int c = 1;
        int now =0;
        for(int i=0;i<n;i++){
            if(now==result[i]){
                c++;
            }else {
                c=1;
            }
            now = result[i];
            if(c>=3)return false;
            if(result[i]==answer[i]){
                ans++;
            }
        }
        return ans>=5;
    }




}