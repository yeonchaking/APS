import java.util.*;

public class Main{

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        Set<Integer> set = new HashSet<>();

        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
            set.add(arr[i]);
        }
        int max =0;

        int idx =0;
        int [] red ;
        for(int i : set){
            idx=0;
            red = new int[n];
            for(int j=0;j<n;j++){
                if(arr[j]==i)continue;
                red[idx]=arr[j];
                idx++;
            }

            int con = 1;
            for (int j=0;j<n-1;j++){
                if(red[j]==red[j+1])con++;
                else {
                    max=max>con?max:con;
                    con=1;
                }
                if(red[j+1]==0)break;
            }
        }

        System.out.println(max);


    }




}

