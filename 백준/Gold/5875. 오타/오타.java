import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] chars = br.readLine().toCharArray();
        int len = chars.length;
        int [] arr = new int[len];
        int [] prefix = new int[len];
        int [] surfix = new int[len];
        int num1 = 0,num2 = 0;
        for(int i=0;i<len;i++){
            if(chars[i]=='('){
                arr[i]++;
                num1++;
            }else {
                arr[i]--;
                num2++;
            }

            if(i==0){
                prefix[i]=arr[i];
            }else {
                prefix[i]=arr[i]+prefix[i-1];
            }
        }
        surfix[len-1]=prefix[len-1];
        for(int i = len-2;i>=0;i--){
            surfix[i]=Math.min(prefix[i],surfix[i+1]);
        }
//        System.out.println(Arrays.toString(arr));
//        System.out.println(Arrays.toString(prefix));
//        System.out.println(Arrays.toString(surfix));
        if(prefix[len-1]==0){
            if(surfix[0]>0) System.out.println(1);
            else System.out.println(0);
        }else if (prefix[len-1]==-2){
            int cnt =0;
            for(int i=0;i<len-1;i++){
                if(arr[i]==-1)cnt++;
                if(prefix[i]<-2){
                    System.out.println(0);
                    break;
                }else if(prefix[i]<0){
                    System.out.println(cnt);
                    break;
                }
            }
        }else if(prefix[len-1]==2){
            int cnt =0;
            for(int i=len-1;i>=0;i--){
                if(surfix[i]<2){
                    System.out.println(cnt);
                    break;
                }
                if(arr[i]==1)cnt++;
            }
        }else {
            System.out.println(0);
        }

    }
}