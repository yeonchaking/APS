import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int [] arr = new int[n];
		for(int i=0;i<n;i++) {
			arr[i]= sc.nextInt();
		}
		
		int L = 0;
		int R = n-1;
		
		int max = 0;
		
		int now = 0;
		while(L<R) {
			now = Math.min(arr[L],arr[R])*(R-L-1);
			if(now>max) {
				max = now;
			}
			if(arr[L]>arr[R]) {
				R--;
			}else {
				L++;
			}
		}		
		System.out.println(max);
	}
	
}