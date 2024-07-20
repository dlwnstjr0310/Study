import java.util.Scanner;

public class Main {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		long x = sc.nextLong();

		long sum = 0;
		for (int i = 1; i < x; i++) {
			sum += i;
		}

		System.out.println(sum);
		System.out.println(2);
	}
}