import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		StringBuilder sb = new StringBuilder();

		int num = Integer.parseInt(st.nextToken());

		int slow = 1;
		int fast = 1;
		int sum = 0;
		int count = 1;

		while (true) {

			if (sum >= num) {
				sum -= slow++;
			} else if (fast == num) {
				break;
			} else {
				sum += fast++;
			}
			if (sum == num) {
				count++;
			}
		}
		System.out.println(count);
	}
}