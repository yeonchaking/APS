import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int a,b,c;
    static long[] A,B,C;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
       A = new long[a];
        B = new long[b];
        C = new long[c];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<a;i++){
           A[i]=Long.parseLong(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<b;i++){
            B[i]=Long.parseLong(st.nextToken());
        }        st = new StringTokenizer(br.readLine());
        for(int i=0;i<c;i++){
            C[i]=Long.parseLong(st.nextToken());
        }
        Arrays.sort(A);
        Arrays.sort(B);
        Arrays.sort(C);

        int s = 0;
        int e = 0;
        long min = Integer.MAX_VALUE;
        for(int i=0;i<a;i++){
            for(int j=0;j<b;j++){
                if(A[i]>=B[j]){
                    if(isContain(C,B[j],A[i])){
                        min =  Math.min(min,A[i]-B[j]);
                    };
                }
            }
        }
        for(int i=0;i<b;i++){
            for(int j=0;j<a;j++){
                if(B[i]>=A[j]){
                    if(isContain(C,A[j],B[i])){
                        min =  Math.min(min,B[i]-A[j]);
                    };
                }
            }
        }
        for(int i=0;i<a;i++){
            for(int j=0;j<c;j++){
                if(A[i]>=C[j]){
                    if(isContain(B,C[j],A[i])){
                        min =  Math.min(min,A[i]-C[j]);
                    };
                }
            }
        }
        for(int i=0;i<c;i++){
            for(int j=0;j<a;j++){
                if(C[i]>=A[j]){
                    if(isContain(B,A[j],C[i])){
                        min =  Math.min(min,C[i]-A[j]);
                    };
                }
            }
        }
        for(int i=0;i<c;i++){
            for(int j=0;j<b;j++){
                if(C[i]>=B[j]){
                    if(isContain(A,B[j],C[i])){
                        min =  Math.min(min,C[i]-B[j]);
                    };
                }
            }
        }
        for(int i=0;i<b;i++){
            for(int j=0;j<c;j++){
                if(B[i]>=C[j]){
                    if(isContain(A,C[j],B[i])){
                        min = Math.min(min,B[i]-C[j]);
                    };
                }
            }
        }

        System.out.println(min);



    }

    static boolean isContain(long[] arr,long s, long e){
        int left = 0;
        int right = arr.length;
        int mid ;
//        System.out.println(Arrays.toString(arr)+" "+s+" "+e);
        while(left<right){
            mid = (left+right)/2;
//            System.out.println(left+" "+right);
            if(arr[mid]<s){
                left= mid+1;
            } else if (arr[mid]>e) {
                right = mid;
            }else {
//                System.out.println("true");
                return true;
            }
        }
//        System.out.println("F");
        return false;
    }

}