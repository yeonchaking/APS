import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int cnt =0;
        for(int i=1;i<=500;i++){
            for(int j=i;j<=500;j++){
                if(i*i+n==j*j)cnt++;
            }
        }

        System.out.println(cnt);

    }


}