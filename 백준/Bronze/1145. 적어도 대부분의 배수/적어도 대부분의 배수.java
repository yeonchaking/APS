import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int[] num = new int[5];

		for (int i = 0; i < 5; i++) {
			num[i] = sc.nextInt();
		} // 다섯 숫자를 배열에 넣고
		Arrays.sort(num); // 오름차순으로 정렬한다
		int i = num[0]; // 찾기 시작할 숫자는 주어진 수 중 가장 낮은 수
		int cnt;
		outer: while (true) { // 반복문을 돌린다
			cnt = 0; 

			for (int j = 0; j < 5; j++) { // i를 num배열에 있는 각각의 수로 나눴을때 나눠떨어지면 카운트
				if (i % num[j] == 0) {
					cnt++;
//					System.out.println(i);
				}
			}

			for (int j = 0; j < 5; j++) { 
				if (cnt >= 3) { // 카운트가 3이상인 수 즉 적어도 3개의 수의 배수를 찾고 출력한다
					System.out.println(i);
					break outer;
				}
			}
			i++;

		}
	}
}