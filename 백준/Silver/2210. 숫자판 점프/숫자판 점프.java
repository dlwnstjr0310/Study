import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {

	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static String[][] map = new String[5][5];
	static Set<String> set = new HashSet<>();

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int i = 0; i < 5; i++) {
			map[i] = br.readLine().split(" ");
		}

		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				dfs(i, j, 0, new StringBuilder(map[i][j]));
			}
		}

		System.out.println(set.size());
	}

	private static void dfs(int row, int col, int count, StringBuilder sb) {

		if (count == 5) {
			set.add(sb.toString());
			return;
		}

		for (int i = 0; i < 4; i++) {

			int nr = row + dx[i];
			int nc = col + dy[i];

			if (0 <= nr && nr < 5 && 0 <= nc && nc < 5) {
				sb.append(map[nr][nc]);
				dfs(nr, nc, count + 1, sb);
				sb.deleteCharAt(sb.length() - 1);
			}

		}
	}

	private static void dfs(int row, int col, int count, String str) {

		if (count == 5) {
			set.add(str);
			return;
		}

		for (int i = 0; i < 4; i++) {

			int nr = row + dx[i];
			int nc = col + dy[i];

			if (0 <= nr && nr < 5 && 0 <= nc && nc < 5) {
				dfs(nr, nc, count + 1, str + map[nr][nc]);
			}

		}
	}
}