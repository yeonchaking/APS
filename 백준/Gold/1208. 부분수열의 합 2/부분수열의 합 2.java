import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int n,q;
    static long cnt,s;

    static int[] arr1;
    static int[] arr2;
    static int[] arr3;
    static int[] arr4;
    static ArrayList<Long> list1;
    static ArrayList<Long> list2;
    static ArrayList<Long> list3;
    static ArrayList<Long> list4;
    static boolean[] visited1;
    static boolean[] visited2;


    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        q = n/4;
        s = Long.parseLong(st.nextToken());
        cnt =0;
        arr1 = new int[q];
        arr2 = new int[q];
        arr3 = new int[q];
        arr4 = new int[n-3*q];
        visited1 = new boolean[n];
        visited2 = new boolean[n-3*q];
        list1=new ArrayList<>();
        list2=new ArrayList<>();
        list3=new ArrayList<>();
        list4=new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<q;i++){
            arr1[i]=Integer.parseInt(st.nextToken());
        }
        for(int i=0;i<q;i++){
            arr2[i]=Integer.parseInt(st.nextToken());
        }
        for(int i=0;i<q;i++){
            arr3[i]=Integer.parseInt(st.nextToken());
        }
        for(int i=0;i<n-3*q;i++){
            arr4[i]=Integer.parseInt(st.nextToken());
        }
        recur1(0,0);
        visited1= new boolean[n];
        recur2(0,0);
        visited1= new boolean[n];
        recur3(0,0);
        recur4(0,0);
//        Collections.sort(list1);
//        Collections.sort(list2);
//        Collections.sort(list3);
//        Collections.sort(list4);

        ArrayList<Long> sumList1 = new ArrayList<>();
        ArrayList<Long> sumList2 = new ArrayList<>();
        for(long i : list1) {
            for(long j : list2) {
                    sumList1.add(i + j);

            }
        }
        for(long i : list3) {
            for(long j : list4) {
                sumList2.add(i + j);

            }
        }
        Collections.sort(sumList1);
        Collections.sort(sumList2);
//        System.out.println(sumList1);
//        System.out.println(sumList2);
//                System.out.println(sum);
        int left = 0;
        int right = sumList2.size() - 1;
        while(left < sumList1.size() && right >= 0) {
            long currentSum = sumList1.get(left) + sumList2.get(right);

            if(currentSum == s) {
                long leftCount = 1, rightCount = 1;
                while(left + 1 < sumList1.size() && Objects.equals(sumList1.get(left), sumList1.get(left + 1))) {
                    leftCount++;
                     left++;
               }
               while(right - 1 >= 0 && Objects.equals(sumList2.get(right), sumList2.get(right - 1))) {
                     rightCount++;
                    right--;
               }
//        System.out.println(leftCount+" / "+rightCount);
//                System.out.println(currentSum+" "+s);
            cnt += leftCount * rightCount;
            left++;
            right--;
        } else if(currentSum < s) {
           left++;
        } else {
          right--;
            }
        }

        if(s == 0) cnt--;
        System.out.println(cnt);
    }

    static void recur1(int cur,int sum){
        if(cur==q){
            list1.add((long)sum);
            return;
        }
        visited1[cur]=true;
        recur1(cur+1,sum+arr1[cur]);
        visited1[cur]=false;
        recur1(cur+1,sum);
    }
    static void recur2(int cur,int sum){
        if(cur==q){
            list2.add((long)sum);
            return;
        }
        visited1[cur]=true;
        recur2(cur+1,sum+arr2[cur]);
        visited1[cur]=false;
        recur2(cur+1,sum);
    }
    static void recur3(int cur,int sum){
        if(cur==q){
            list3.add((long)sum);
            return;
        }
        visited1[cur]=true;
        recur3(cur+1,sum+arr3[cur]);
        visited1[cur]=false;
        recur3(cur+1,sum);
    }
    static void recur4(int cur,int sum){
        if(cur==n-3*q){
            list4.add((long)sum);
            return;
        }
        visited2[cur]=true;
        recur4(cur+1,sum+arr4[cur]);
        visited2[cur]=false;
        recur4(cur+1,sum);
    }





}