import javax.swing.border.SoftBevelBorder;
import java.io.*;
import java.util.*;

public class Main {




    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int[][] prefix = new int[n][3];

        for(int i=0;i<n;i++){
            char tmp = br.readLine().charAt(0);
            if(tmp=='P'){
                arr[i]=0;
                if(i!=0){
                    prefix[i][0]=prefix[i-1][0];
                    prefix[i][1]=prefix[i-1][1];
                    prefix[i][2]=prefix[i-1][2];
                }
                prefix[i][2]++;
            }else if(tmp=='H'){
                arr[i]=1;
                if(i!=0){
                    prefix[i][0]=prefix[i-1][0];
                    prefix[i][1]=prefix[i-1][1];
                    prefix[i][2]=prefix[i-1][2];
                }
                prefix[i][0]++;
            }else {
                arr[i]=2;
                if(i!=0){
                    prefix[i][0]=prefix[i-1][0];
                    prefix[i][1]=prefix[i-1][1];
                    prefix[i][2]=prefix[i-1][2];
                }
                prefix[i][1]++;
            }
        }

        int [] fin = new int[3];
        fin[0]=prefix[n-1][0];
        fin[1]=prefix[n-1][1];
        fin[2]=prefix[n-1][2];

//        for(int i=0;i<n;i++){
//            System.out.println(Arrays.toString(prefix[i]));
//        }
//        System.out.println();
//        System.out.println(Arrays.toString(fin));
        int result =0;
        int now,tmp;
        for(int i=0;i<n;i++){
            if(i==0){
                tmp = Math.max(fin[0],fin[1]);
                tmp = Math.max(tmp,fin[2]);
                now = 0;
            }else {
                tmp =Math.max((fin[0]-prefix[i-1][0]),(fin[1]-prefix[i-1][1]));
                tmp = Math.max((fin[2]-prefix[i-1][2]),tmp);
                now =Math.max(prefix[i-1][0],prefix[i-1][1]);
                now = Math.max(prefix[i-1][2],now);
            }
            result= Math.max(result,tmp+now);
//            System.out.println(tmp+" "+now+" "+result);
        }
        System.out.println(result);









    }
}