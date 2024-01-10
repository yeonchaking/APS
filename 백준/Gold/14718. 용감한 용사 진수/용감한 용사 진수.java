import java.util.*;

public class Main {

    static int N ;
    static int K;
    static int[][] solArr;
    static Set<Integer>[] solSet;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        K = sc.nextInt();
        solArr  = new int[N][3];
        solSet = new Set[3];

        solSet[0]= new HashSet<>();
        solSet[1]= new HashSet<>();
        solSet[2]= new HashSet<>();
        for(int i=0;i<N;i++){
            solArr[i][0]=sc.nextInt();
            solArr[i][1]=sc.nextInt();
            solArr[i][2]=sc.nextInt();

            solSet[0].add(solArr[i][0]);
            solSet[1].add(solArr[i][1]);
            solSet[2].add(solArr[i][2]);
        }

        int min = Integer.MAX_VALUE;
        for(int i : solSet[0]){
            for(int j : solSet[1]){
                for(int k : solSet[2]){

                    if(check(i,j,k)){
                        min = i+j+k<min?i+j+k:min;
                    }
                }
            }
        }

        System.out.println(min);

    }


    static boolean check(int str,int dex, int inte){
        int win = 0;

        for(int i=0;i<N;i++){
            if(solArr[i][0]<=str&&solArr[i][1]<=dex&&solArr[i][2]<=inte){
                win++;
            }
        }
        if(win>=K){
            return true;
        }else {
            return false;
        }
    }


}