import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static boolean isPrime(long x){
        if(x < 2) return false;
        for(long i = 2; i * i <= x; i++){
            if(x % i == 0) return false;
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine());

        if(n == 2 || n == 5){
            System.out.println("yes");
            return;
        }

        if (!isPrime(n)) {
            System.out.println("no");
            return;
        }

        long reversed = reverse(n);
        if (isPrime(reversed)) {
            System.out.println("yes");
        } else {
            System.out.println("no");
        }
    }

    static long reverse(long in){
        long reversed = 0;
        while (in > 0){
            long tmp = in % 10;
            if(tmp == 0 || tmp == 1 || tmp == 2 || tmp == 5 || tmp == 8){
                reversed = reversed * 10 + tmp;
            } else if(tmp == 6 || tmp == 9){
                if(tmp == 6){
                    reversed = reversed * 10 + 9;
                } else {
                    reversed = reversed * 10 + 6;
                }
            } else {
                return -1;
            }
            in /= 10;
        }
        return reversed;
    }
}