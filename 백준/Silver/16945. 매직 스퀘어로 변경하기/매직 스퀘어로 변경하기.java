import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int n,min;
    static int[][] arr;
    static boolean[] visited;


    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st ;
        n =0;
        min = Integer.MAX_VALUE;
        arr = new int[3][3];
        visited = new boolean[10];
        for(int i=0;i<3;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<3;j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        recur(0,0);
        System.out.println(min);
    }

    static void recur(int cur,int sum){

        if(sum>=min)return;

        if(cur==9){

            outer:for(int i=1;i<=9;i++){
                for(int j=0;j<=2;j++){
                    for(int k=0;k<=2;k++){
                        if(arr[j][k]==i)continue outer;
                    }
                }
                return;
            }


            if(!square())return;
            min = Math.min(sum,min);
            return;
        }
        recur(cur+1,sum);

        for(int i=1;i<=9;i++){
            if(visited[i])continue;
            visited[i]=true;
            int tmp = arr[cur/3][cur%3];
            arr[cur/3][cur%3]=i;
            recur(cur+1,sum+Math.abs(tmp-i));
            arr[cur/3][cur%3]=tmp;
            visited[i]=false;
        }


    }

    static boolean square(){
        boolean check1=false,check2 = false,check3 = false;

        if((arr[0][0]+arr[0][1]+arr[0][2]==arr[1][0]+arr[1][1]+arr[1][2])&&(arr[1][0]+arr[1][1]+arr[1][2]==arr[2][0]+arr[2][1]+arr[2][2]))check1=true;
        if((arr[0][0]+arr[1][0]+arr[2][0]==arr[0][1]+arr[1][1]+arr[2][1])&&(arr[0][1]+arr[1][1]+arr[2][1]==arr[0][2]+arr[1][2]+arr[2][2]))check2=true;
        if(arr[0][0]+arr[1][1]+arr[2][2]==arr[0][2]+arr[1][1]+arr[2][0])check3=true;

        return check1&&check2&&check3;
    }


}