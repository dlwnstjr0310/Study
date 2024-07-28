import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int length = Integer.parseInt(br.readLine());

		boolean[] sold = new boolean[1000001];
		StringTokenizer st = new StringTokenizer(br.readLine());

		for (int i = 0; i < length; i++) {
			sold[Integer.parseInt(st.nextToken())] = true;
		}

		for (int i = 1; i < 1000001; i++) {
			if (!sold[i]) {
				System.out.println(i);
				break;
			}
		}
	}
}