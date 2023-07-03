import java.util.Scanner;

public class Main {
	static int[] arr;
	static int N;
	static int cnt;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		arr = new int[N];
		cnt = 0;
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		
		while(!isA()) {
			
			if(isPossibleHalf()) {
				cutHalf();
			}else {
				cutOdd();
			}
		}
		
		System.out.println(cnt);
	}

	static boolean isA() {
		for (int i = 0; i < N; i++) {
			if (arr[i] != 0) {
				return false;
			}
		}
		return true;
	}

	static boolean isPossibleHalf() {
		for (int i = 0; i < N; i++) {
			if (arr[i] % 2 != 0) {
				return false;
			}
		}
		return true;
	}

	static void cutOdd() {
		for (int i = 0; i < N; i++) {
			if (arr[i] % 2 != 0) {
				arr[i]--;
				cnt++;
			}
		}
	}

	static void cutHalf() {
		for (int i = 0; i < N; i++) {
			arr[i] = arr[i] / 2;
		}
		cnt++;
	}

}