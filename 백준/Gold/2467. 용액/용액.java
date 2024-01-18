import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine());

		int[] arr = new int[N];
		StringTokenizer st = new StringTokenizer(bf.readLine());

		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int left = 0;
		int right = N - 1;
		int L = 0;
		int R = 0;
		int mid = 0;
		int result = Integer.MAX_VALUE;

		while (left  < right) {
			mid = arr[left] + arr[right];
			if (Math.abs(result) > Math.abs(mid)) {
				
				if (mid > 0) {
					L = arr[left];
					R = arr[right];
					right--;
					if(left==right) {
						right++;
						break;
					}
					result=mid;
				} else if (mid < 0) {
					L = arr[left];
					R = arr[right];
					left++;
					if(left==right) {
						left--;
						break;
					}
					result=mid;
				} else if (mid == 0) {
					System.out.println(arr[left] + " " + arr[right]);
					return;
				}

			} else {
				if (mid > 0) {
					right--;
				} else if (mid < 0) {
					left++;
				}
			}
		}
		System.out.println(L + " " + R);
	}
}