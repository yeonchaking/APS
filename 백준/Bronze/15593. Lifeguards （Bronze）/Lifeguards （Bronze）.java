import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [][] arr = new int[n][2];
        int[] cnt = new int[1000];
        for(int i=0;i<n;i++){
            arr[i][0]=sc.nextInt();
            arr[i][1]=sc.nextInt();
            for(int j=arr[i][0];j<arr[i][1];j++){
                cnt[j]++;
            }
        }
        int max =0;

        for(int i=0;i<n;i++){
            int count = 0;
            for(int j=arr[i][0];j<arr[i][1];j++){
                cnt[j]--;
            }
            for(int j=0;j<1000;j++){
                if(cnt[j]>=1)count++;
            }
            max = max>count?max:count;
            for(int j=arr[i][0];j<arr[i][1];j++){
                cnt[j]++;
            }
        }

        System.out.println(max);


    }



}