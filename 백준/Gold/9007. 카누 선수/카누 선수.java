import javax.swing.border.SoftBevelBorder;
import java.io.*;
import java.util.*;

public class Main {




    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
       outer : for(int tc =1;tc<=T;tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());

            int [] class1 = new int[n];
            int [] class2 = new int[n];
            int [] class3 = new int[n];
            int [] class4 = new int[n];
           st = new StringTokenizer(br.readLine());
            for(int i=0;i<n;i++){
                class1[i]=Integer.parseInt(st.nextToken());
            }
           st = new StringTokenizer(br.readLine());
            for(int i=0;i<n;i++){
                class2[i]=Integer.parseInt(st.nextToken());
            }
           st = new StringTokenizer(br.readLine());
            for(int i=0;i<n;i++){
                class3[i]=Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine());
            for(int i=0;i<n;i++){
                class4[i]=Integer.parseInt(st.nextToken());
            }

            int [] arr1 = new int[n*n];
            int [] arr2 = new int[n*n];

            int idx=0;
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    arr1[idx++]=class1[i]+class2[j];
                }
            }
           idx=0;
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    arr2[idx++]=class3[i]+class4[j];
                }
            }
            Arrays.sort(arr1);
           Arrays.sort(arr2);

            int s =0;
            int e =n*n-1;
            int result = Integer.MAX_VALUE;
            int sum =0;
//           System.out.println(Arrays.toString(arr1));
//           System.out.println(Arrays.toString(arr2));
            while (s<n*n&&e>=0){
//                System.out.println(s+" "+e);
                sum = arr1[s]+arr2[e];


                if(sum==k){
                    sb.append(k+"\n");
                    continue outer;
                }else if(sum>k){
                    e--;
                }else {
                    s++;
                }

                if(Math.abs(result-k)>Math.abs(sum-k)){
                    result=sum;
                }else if(Math.abs(result-k)==Math.abs(sum-k)){
                    result = Math.min(result,sum);
                }
            }
            sb.append(result+"\n");
        }
        System.out.println(sb.toString());
    }
}