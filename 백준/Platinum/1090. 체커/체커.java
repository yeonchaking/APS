import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    static int N ;
static int[][] arr;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
         N = sc.nextInt();

        arr = new int[N][2];
        Set<Integer> xSet = new HashSet<>();
        Set<Integer> ySet = new HashSet<>();

         for(int i=0;i<N;i++){
             arr[i][0]=sc.nextInt();
             arr[i][1]=sc.nextInt();

             xSet.add(arr[i][0]);
             ySet.add(arr[i][1]);
         }
         int [] ans = new int[N];

         for(int k=0;k<N;k++) {
             int min = Integer.MAX_VALUE;
             for (int i : xSet) {
                 for (int j : ySet) {
                    int tmp =findMinRange(k,i,j);
                    if(tmp<min)min=tmp;
                 }
             }
             ans[k]=min;
         }

         StringBuilder sb = new StringBuilder();
         for(int i=0;i<N;i++){
             sb.append(ans[i]+" ");
         }
        System.out.println(sb.toString());


    }

    static int findMinRange(int num,int x, int y){
        int []ran=new int[N];
        for(int i=0;i<N;i++){

            int sum=Math.abs(arr[i][0]-x)+Math.abs(arr[i][1]-y);
            ran[i]=sum;

        }
        Arrays.sort(ran);
        int min =0;
        for(int i=0;i<=num;i++){
            min+=ran[i];
        }
        return min;
    }


}