import java.io.*;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		StringBuilder sb = new StringBuilder();

		int a = Integer.parseInt(st.nextToken());

		int target = a;
		int fiveCount = 0;
		int threeCount = 0;

		while (target > 0) {
			target -= 5;
			fiveCount++;
		}

		target = a;

		while (target > 0) {
			target -= 3;
			threeCount++;
		}

		int totalCount = -1;

		for (int i = 0; i <= fiveCount; i++) {
			for (int j = 0; j <= threeCount; j++) {
				if ((5 * i) + (3 * j) == a) {
					totalCount = i + j;
				}
			}
		}

		bw.write(String.valueOf(sb.append(totalCount)));
		bw.flush();
		bw.close();

	}
}
