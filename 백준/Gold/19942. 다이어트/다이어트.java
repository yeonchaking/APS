import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int n,min;
    static int[] standard;
    static int[][] nutrient;

    static boolean[] contain;
    static boolean[]answer ;




    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        standard = new int[4];
        for(int i =0;i<4;i++){
            standard[i]=Integer.parseInt(st.nextToken());
        }
        nutrient = new int[n][5];
        contain = new boolean[n];
        answer = new boolean[n];
        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<5;j++){
                nutrient[i][j]=Integer.parseInt(st.nextToken());
            }
        }
        min =10000;

        recur(0);

        if(min==10000){
            System.out.println(-1);
        }else {
            System.out.println(min);
            for (int i = 1; i <= n; i++) {
                if (answer[i - 1]) {
                    System.out.print(i);
                    System.out.print(" ");
                }
            }
        }


    }

    static void recur(int cur){
        if(cur==n){
            int result = check();
            if(result==-1)return;
            if(min>result){
                min = result;
                for(int i=0;i<n;i++){
                    answer[i]=contain[i];
                }
            }else if(min==result){

                makeAnswerArr();

            }
            return;
        }
        contain[cur]=true;
        recur(cur+1);
        contain[cur]=false;
        recur(cur+1);
    }

    static void makeAnswerArr(){
        
        for(int i=0;i<n-1;i++) {
            if (contain[i] && answer[i]) {
                for (int j = i + 1; j < n; j++) {
                    if (!contain[j] && answer[j]) {
                        for (int k = j + 1; k < n; k++) {
                            if (contain[k]) return;
                        }
                        for (int k = 0; k < n; k++) {
                            answer[k] = contain[k];
                        }
                        return;
                    } else if (!answer[j] && contain[j]) {
                        for (int k = j + 1; k < n; k++) {
                            if (answer[k]) break;
                        }
                        for (int k = 0; k < n; k++) {
                            answer[k] = contain[k];
                        }
                    }
                }
                break;
            } else if (!contain[i] && answer[i]) {
                return;
            } else if (!answer[i] && contain[i]) {
                for (int j = 0; j < n; j++) {
                    answer[j] = contain[j];
                }
                return;
            }
        }
    }
    static int check(){
        int[] arr = new int[5];
        for(int i=0;i<n;i++){
            if(!contain[i])continue;
            for(int j=0;j<5;j++){
                arr[j]+=nutrient[i][j];
            }
        }
        for(int i=0;i<4;i++){
            if(arr[i]<standard[i])return -1;
        }
        return arr[4];
    }





}