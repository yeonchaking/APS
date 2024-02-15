import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int[] nums;
	static int N;
	static int M;

	static boolean[] visited;
	static int[] result;

	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();

		visited = new boolean[N];
		nums = new int[N];
		result = new int[M];

		for (int i = 0; i < N; i++) {
			nums[i] = i + 1;
		}

		perm(0);
		System.out.println(sb.toString());
	}

	public static void perm(int idx) {
		// 기저조건
		if (idx == M) {
			for (int i = 0; i < M; i++) {
				sb.append(result[i] + " ");
			}
			sb.append("\n");
			return;
		}
		// 재귀조건
		for (int i = 0; i < N; i++) {
			if (visited[i])
				continue;

			result[idx] = nums[i];
			visited[i] = true;
			perm(idx + 1);
			visited[i] = false;
		}
	}

}
