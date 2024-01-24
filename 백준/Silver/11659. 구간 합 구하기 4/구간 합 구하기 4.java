
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[] arr = new int[N + 1];
		int[] cnt = new int[N + 1];

		StringTokenizer str = new StringTokenizer(bf.readLine());
		for (int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(str.nextToken());
			cnt[i] = cnt[i - 1] + arr[i];
		}
		StringBuilder sb = new StringBuilder();

//		System.out.println(Arrays.toString(arr));
//		System.out.println(Arrays.toString(cnt));
		StringTokenizer str1;
		int x, y;

		for (int i = 0; i < M; i++) {
			str1 = new StringTokenizer(bf.readLine());
			x = Integer.parseInt(str1.nextToken());
			y = Integer.parseInt(str1.nextToken());

			sb.append((cnt[y] - cnt[x-1]) + "\n");
		}

		System.out.println(sb.toString());
	}

}