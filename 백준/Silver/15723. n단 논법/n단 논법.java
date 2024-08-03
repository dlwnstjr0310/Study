import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static boolean[][] map = new boolean[26][26];

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(br.readLine());

		for (int i = 0; i < n; i++) {
			String[] split = br.readLine().split(" ");
			char before = split[0].charAt(0);
			char after = split[2].charAt(0);

			int a = before - '0' - 49;
			int b = after - '0' - 49;

			map[a][b] = true;
		}

		int m = Integer.parseInt(br.readLine());

		for (int i = 0; i < m; i++) {
			String[] split = br.readLine().split(" ");
			char before = split[0].charAt(0);
			char after = split[2].charAt(0);

			int a = before - '0' - 49;
			int b = after - '0' - 49;

			sb.append(
					dfs(a, b) ? 'T' : 'F'
			).append('\n');
		}

		System.out.print(sb);
	}

	static boolean dfs(int a, int b) {
		if (a == b) {
			return true;
		}

		for (int i = 0; i < map.length; i++) {
			if (map[a][i] && dfs(i, b)) {
				return true;
			}
		}
		return false;
	}
}
