import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int M;
	static int[] arr;
	static boolean[] used;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		used = new boolean[N];
		arr = new int[M];

		calculator(0);

		System.out.print(sb);
	}

	private static void calculator(int count) {

		if (count == M) {
			for (int i : arr) {
				sb.append(i).append(' ');
			}
			sb.append('\n');
		} else {
			for (int i = 0; i < N; i++) {
				if (!used[i]) {
					used[i] = true;
					arr[count] = i + 1;
					calculator(count + 1);
					used[i] = false;
				}
			}
		}
	}
}