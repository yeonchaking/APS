import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		StringBuilder sb = new StringBuilder();
		String str = sc.nextLine();
		for(int i = 1;i<=n;i++) {
			str = sc.nextLine();
			sb.append(i+". "+str+"\n");
		}
		
		System.out.println(sb.toString());
	}
}