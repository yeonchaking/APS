import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static boolean [] prime;



    static HashMap<Integer,Integer> facMap ;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N  = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        facMap = new HashMap<>();
        prime= new boolean[1000];
        Arrays.fill(prime,true);
        prime[0]=false;
        prime[1]=false;
        for(int i=2;i<1000;i++){
            for (int j=i+i;j<1000;j+=i){
                prime[j]=false;
            }
        }
        for(int i=0;i<N;i++){
            arr[i]=Integer.parseInt(st.nextToken());
            factorization(arr[i]);
        }


      Set<Integer> set = facMap.keySet();
        long max =1;
        ArrayList<Integer> list = new ArrayList<>();
        for(int i:set){
            long tmp=facMap.get(i)/N;
            if(tmp>=1){
                for(int j=0;j<tmp;j++){
                    list.add(i);
                }
//                max*=(tmp*i);
            }
        }

        int move =0;
//        System.out.println(facMap);

        for(int i=0;i<N;i++){
            for(int j:list){
                if(arr[i]%j==0){
                    arr[i]/=j;
                }else {
                    move++;
//                    System.out.println(i+" "+j);
                }
            }
        }

        for(int i:list){
            max*=i;
        }
        System.out.println(max+" "+move);


    }

    static void factorization(int x){
        for(int i=2;i<=Math.sqrt(x);i++){
            if(prime[i]&&x%i==0){
                while (x%i==0){
                    if(facMap.containsKey(i)){
                        facMap.put(i, facMap.get(i)+1);
                    }else {
                        facMap.put(i,1);
                    }
                    x/=i;
                }
            }
        }
        if(x>1){
            if(facMap.containsKey(x)){
                facMap.put(x, facMap.get(x)+1);
            }else {
                facMap.put(x,1);
            }
        }
    }






}