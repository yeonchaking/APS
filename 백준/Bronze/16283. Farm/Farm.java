import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int n = sc.nextInt();
        int w = sc.nextInt();

        int x =0,y=0;
        int ansx = 0;
        int ansy =0;
        int pos = 0;
        for(int i=1;i<n;i++){
            x = i;
            y= n-x;
            if(a*x+b*y==w){
                ansx= x;
                ansy= y;
                pos++;
            }
        }

        if(pos==1){
            System.out.println(ansx+" "+ansy);
        }else {
            System.out.println(-1);
        }




    }

}