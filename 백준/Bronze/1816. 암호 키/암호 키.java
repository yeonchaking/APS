import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<n;i++){
            long password = sc.nextLong();
            for(int j=2;j<1000000;j++){
                if(password%j==0) {
                    System.out.println("NO");
                    break;
                }
                if(j==999999) System.out.println("YES");
            }
        }



    }



}