import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int A = sc.nextInt();
		int B = sc.nextInt();

		int root1 = (int) (-A - Math.sqrt((A * A) - B));

		int root2 = (int) (-A + Math.sqrt((A * A) - B));

		if (root1 == root2) {
			System.out.println(root1);
		} else {
			System.out.println(root1 + " " + root2);
		}
	}

}
