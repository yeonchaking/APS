import java.util.*;

public class Main {
    static ArrayList<Long> arr;
    static long n;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextLong();
        arr = new ArrayList<>();

        for(long i =2;i<=Math.sqrt(n);i++){
            if(n%i==0){
                n/=i;
                arr.add(i);
                i--;
            }
        }
        if(n>1){
            arr.add(n);
        }
        Collections.sort(arr); // 이미 되어있어서 필요없을듯?
        System.out.println(arr.size());
        for(long i:arr){
            System.out.print(i+" ");
        }

    }











}