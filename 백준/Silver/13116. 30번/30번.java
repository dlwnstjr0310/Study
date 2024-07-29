import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int num = Integer.parseInt(br.readLine());

		for (int i = 0; i < num; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());

			while (A != B) {
				if (A > B) {
					A /= 2;
				} else {
					B /= 2;
				}
			}

			sb.append(A * 10).append('\n');
		}

		System.out.print(sb);
	}
}