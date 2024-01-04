import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int[] mush = new int[10];
		for (int i = 0; i < 10; i++) {
			mush[i] = sc.nextInt();
		}

		int a = 0; // 100을 넘었을 때
		int b = 0; // 100을 넘기 전 마지막
		int result = 0;
		int real = 100;
		int realkk = 0;
		int[] sum = new int[10];
		for (int i = 9; i >= 0; i--) {
			for (int j = 0; j < 10 - i; j++) {
				sum[i] += mush[j];
			}
		}
		int[] dis = new int[10];
		int min = 100;
		int minidx = 0;
		for (int i = 0; i < 10; i++) {
			dis[i] = Math.abs(sum[i] - 100);
			if (dis[i] < min) {
				min = dis[i];
				minidx = i;
			}
		}
		System.out.println(sum[minidx]);

	}
}