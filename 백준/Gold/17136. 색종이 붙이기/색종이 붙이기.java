import java.util.*;

public class Main {
	static int[][] paper;
	static int[] count;
	static int ans = Integer.MAX_VALUE;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		paper = new int[10][10];
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				paper[i][j] = sc.nextInt();
			}
		}

		count = new int[6];
		Arrays.fill(count, 5);
		dfs(0, 0);

		if (ans == Integer.MAX_VALUE) {
			System.out.println(-1);
		} else {
			System.out.println(ans);
		}

		sc.close();
	}

	// 색종이 붙이기
	static void color(int r, int c, int size) {
		for (int i = r; i < r + size; i++) {
			for (int j = c; j < c + size; j++) {
				paper[i][j] = 0;
			}
		}
	}

	// 색종이 떼기
	static void colorBack(int r, int c, int size) {
		for (int i = r; i < r + size; i++) {
			for (int j = c; j < c + size; j++) {
				paper[i][j] = 1;
			}
		}
	}

	static void dfs(int cnt, int idx) {
		// 1로 채워진 모든 칸을 덮었을 때, 필요한 색종이 개수 갱신
		if (idx == 100) {
			ans = Math.min(ans, cnt);
			return;
		}

		// 최소값 갱신
		if (cnt >= ans) {
			return;
		}

		int r = idx / 10; // 인덱스를 100까지 받으니 행과 열로 나눠줌
		int c = idx % 10;
		if (paper[r][c] == 0) { // 0이면 다음거
			dfs(cnt, idx + 1);
			return;
		}

		for (int i = 5; i >= 1; i--) { // 이 색종이를 붙일거니?
			if (count[i] == 0 || r + i > 10 || c + i > 10) {
				continue; // 남은게 없엉 ㅠ
			}

			boolean flag = true;
			for (int j = r; j < r + i; j++) {
				for (int k = c; k < c + i; k++) {
					if (paper[j][k] == 0) { // 덮을라는데 0 있으면 제껴
						flag = false;
						break;
					}
				}
				if (!flag) {
					break;
				}
			}

			if (flag) {
				count[i]--;
				color(r, c, i);
				dfs(cnt + 1, idx + i);
				colorBack(r, c, i);
				count[i]++;
			}
		}
	}
}