import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static HashMap<Integer,ArrayList<Integer>> map ;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        map = new HashMap<>();
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int [][] dot = new int[n][2];
        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            dot[i][0]=x;
            dot[i][1]=y;
            if(map.containsKey(x)){
                map.get(x).add(y);
            }else {
                map.put(x,new ArrayList<>());
                map.get(x).add(y);
            }
        }

        int cnt = 0;

        for(int i=0;i<n;i++){
            if(checkNum(dot[i][0]+a,dot[i][1])&&checkNum(dot[i][0],dot[i][1]+b)&&checkNum(dot[i][0]+a,dot[i][1]+b)){
                cnt++;
            }
        }
        System.out.println(cnt);
    }

    static boolean checkNum(int x, int y){
        if(map.containsKey(x)){
            return map.get(x).contains(y);
        }else {
            return false;
        }
    }
}