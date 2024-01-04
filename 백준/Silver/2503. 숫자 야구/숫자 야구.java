import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [][] arr = new int[n][3];
        for(int i=0;i<n;i++){
            arr[i][0]=sc.nextInt();
            arr[i][1]=sc.nextInt();
            arr[i][2]=sc.nextInt();
        }

        int sum=0;
        int st =0;
        int ball=0;
        for(int i=1;i<=9;i++){
            for(int j=1;j<=9;j++){
               outer :  for(int k=1;k<=9;k++){
                   if(i==j||j==k||i==k)continue ;
                    for(int l=0;l<n;l++){
                        st=0;
                        ball=0;
                        int hun=arr[l][0]/100;
                        int ten=arr[l][0]/10-10*hun;
                        int one=arr[l][0]%10;

                        if(hun==i)st++;
                        if(ten==j)st++;
                        if(one==k)st++;
                        if(hun!=i&(hun==j||hun==k))ball++;
                        if(ten!=j&(ten==i||ten==k))ball++;
                        if(one!=k&(one==i||one==j))ball++;

                        if(arr[l][1]!=st||arr[l][2]!=ball){
                            continue outer;
                        }
                    }

                    sum++;
                }
            }
        }
        System.out.println(sum);

    }



}

