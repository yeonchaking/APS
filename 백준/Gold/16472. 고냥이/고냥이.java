import java.io.*;
import java.util.*;

public class Main {

    static char[] arr;
    static int n ;
    static int[] possible;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        int s1 =0;
        int s2 =0;
        possible= new int[26];
        arr = br.readLine().toCharArray();
        int result = Integer.MIN_VALUE;
        possible[arr[0]-'a']++;
        int cnt =1;
        while (s2<arr.length){
//            System.out.println(s1+" "+s2+" "+cnt);
//            System.out.println(Arrays.toString(possible));
            if(cnt>n){
                possible[arr[s1]-'a']--;
                if(possible[arr[s1]-'a']==0){
                    cnt--;
                }
                s1++;
            }else {
                if(s2>=arr.length-1)break;
                if(result<s2-s1+1){
//                    System.out.println(" "+ s1+" "+s2);
                    result = s2-s1+1;
                    if(s2==arr.length-2)result++;
                }


                s2++;
                if(possible[arr[s2]-'a']==0){
                    cnt++;
                }
                possible[arr[s2]-'a']++;
            }
        }


        System.out.println(result);
    }
//    static boolean check(int st, int ed){
//
//        int cnt =0;
//        Arrays.fill(possible,false);
//        for(int i=st;i<=ed;i++){
//            if(!possible[arr[i]-'a']) {
//                cnt++;
//                possible[arr[i] - 'a'] = true;
//                if (cnt > n) {
//                    return false;
//                }
//            }
//        }
//        return true;
//    }



}