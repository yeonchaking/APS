import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int n= sc.nextInt();

        int cnt=0;

        for(int i=1;i<n;i++){
            for(int j=1;j<n-i;j++){
                int k = n-i-j;
                if(i%2!=0)continue;
                if(j+2>k)continue;
                if(j==0||k==0)continue;

                cnt++;
            }
        }
        System.out.println(cnt);
    }


}