import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		String str = br.readLine();

		int count = 0;
		while (str.length() > 1) {
			count++;
			str = String.valueOf(str.chars().sum() - (48 * str.length()));
		}

		sb.append(count)
				.append('\n')
				.append(Integer.parseInt(str) % 3 == 0 ? "YES" : "NO");

		System.out.print(sb);
	}
}