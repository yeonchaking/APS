import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[9];
        int sum = 0;
        for(int i=0;i<9;i++){
            arr[i]=sc.nextInt();
            sum+= arr[i];
        }

        Arrays.sort(arr);
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(i==j)continue;
                if(sum-arr[i]-arr[j]==100){
                    for(int k=0;k<9;k++){
                        if(k==i||k==j)continue;
                        System.out.println(arr[k]);
                    }
                    return;
                }
            }
        }





    }

}