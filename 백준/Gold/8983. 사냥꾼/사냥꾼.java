import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int [] arr;
    static int[][] animal ;
    static int N,M,L;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());

        arr = new int[N];
        animal = new int[M][2];
        int max = 0;
        for(int i=0;i<N;i++){
            arr[i]=Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        int cnt =0;
        int animalX =0,animalY = 0;
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            animalX=Integer.parseInt(st.nextToken());
            animalY=Integer.parseInt(st.nextToken());

            if(canShot(BinarySearch(animalX,animalY),animalX,animalY)
            ||canShot(BinarySearch(animalX,animalY)-1,animalX,animalY))cnt++;
        }

        System.out.println(cnt);



    }

    static int BinarySearch(int x, int y){
        int s = 0;
        int e = N;

        int mid ;
        while(s<e){
            mid = (s+e)/2;
            if(arr[mid]<x){
                s = mid+1;
            }else {
                e=mid;
            }
        }
        return e;
    }

    static boolean canShot(int i,int x, int y){
        if(i<0||i>=N)return false;
        return Math.abs(arr[i]-x)+y <= L;
    }



}

