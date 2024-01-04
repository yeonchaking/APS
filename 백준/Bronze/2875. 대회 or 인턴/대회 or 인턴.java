import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k=  sc.nextInt();
        int ans = 0;
        for(int i=0;i<=m;i++){
            if(n-2*i>=0&&m-i>=0&&n+m-3*i>=k)ans=i;
        }

        System.out.println(ans);
    }


}