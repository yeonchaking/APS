import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int n,q;
    static long cnt,s;

    static int[] arr1;
    static int[] arr2;
    static ArrayList<Integer> list1;
    static ArrayList<Integer> list2;
    static boolean[] visited1;
    static boolean[] visited2;


    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        q = n/2;
        s = Long.parseLong(st.nextToken());
        cnt =0;
        arr1 = new int[q];
        arr2 = new int[n-q];
        visited1 = new boolean[n];
        visited2 = new boolean[n-q];
        list1=new ArrayList<>();
        list2=new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<q;i++){
            arr1[i]=Integer.parseInt(st.nextToken());
        }
        for(int i=0;i<n-q;i++) {
            arr2[i] = Integer.parseInt(st.nextToken());
        }
        recur1(0,0);
        recur2(0,0);

        Collections.sort(list1);
        Collections.sort(list2);
        int left = 0;
        int right = list2.size() - 1;
        while(left < list1.size() && right >= 0) {
            long currentSum = list1.get(left) + list2.get(right);

            if(currentSum == s) {
                long leftCount = 1, rightCount = 1;
                while(left + 1 < list1.size() && Objects.equals(list1.get(left), list1.get(left + 1))) {
                    leftCount++;
                     left++;
               }
               while(right - 1 >= 0 && Objects.equals(list2.get(right), list2.get(right - 1))) {
                     rightCount++;
                    right--;
               }
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
            list1.add(sum);
            return;
        }
        visited1[cur]=true;
        recur1(cur+1,sum+arr1[cur]);
        visited1[cur]=false;
        recur1(cur+1,sum);
    }
    static void recur2(int cur,int sum){
        if(cur==n-q){
            list2.add(sum);
            return;
        }
        visited2[cur]=true;
        recur2(cur+1,sum+arr2[cur]);
        visited2[cur]=false;
        recur2(cur+1,sum);
    }
}