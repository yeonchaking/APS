import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(bf.readLine());
		int[] arr1 = new int[N];
		int cnt = 0;
		StringTokenizer st = new StringTokenizer(bf.readLine());
		for (int i = 0; i < N; i++) {
			arr1[i] = Integer.parseInt(st.nextToken());

		}

		Arrays.sort(arr1);

		int M = Integer.parseInt(bf.readLine());
		int[] arr2 = new int[M];
		StringTokenizer st1 = new StringTokenizer(bf.readLine());
		for (int i = 0; i < M; i++) {
			arr2[i] = Integer.parseInt(st1.nextToken());
			if (arr2[i] < arr1[0] || arr2[i] > arr1[N - 1]) {
				sb.append(0 + " ");
				continue;
			} else {
				sb.append(UpperBound(arr2[i], arr1) - LowerBound(arr2[i], arr1) + " ");
			}

		}

		System.out.println(sb.toString());

	}

	public static int BinarySearch(int i, int[] arr) {
		int start = 0;
		int end = arr.length - 1;
		int mid = 0;
		while (start <= end) {
			mid = (start + end) / 2;
			if (arr[mid] == i) {
				return mid;
			}
			if (arr[mid] < i) {
				start = mid + 1;
			} else {
				end = mid - 1;
			}
		}
		return mid;
	}

	public static int LowerBound(int i, int[] arr) {
		int start = 0;
		int end = arr.length;
		int mid = 0;
		while (start < end) {
			mid = (start + end) / 2;
			if (arr[mid] < i) {
				start = mid + 1;
			} else {
				end = mid;
			}
		}
		return end;
	}

	public static int UpperBound(int i, int[] arr) {
		int start = 0;
		int end = arr.length;
		int mid = 0;
		while (start < end) {
			mid = (start + end) / 2;
			if (arr[mid] <= i) {
				start = mid + 1;
			} else {
				end = mid;
			}
		}
		return end;
	}

}