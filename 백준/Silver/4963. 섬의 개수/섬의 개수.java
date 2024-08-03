import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int[][] map;
	static boolean[][] isChecked;
	// 시계방향
	static int[][] dir = {{-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, -1}};


	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int w = Integer.parseInt(st.nextToken());
			int h = Integer.parseInt(st.nextToken());

			if (w == 0 && h == 0) {
				System.out.print(sb);
				break;
			} else {
				map = new int[h][w];
				isChecked = new boolean[h][w];

				for (int i = 0; i < h; i++) {
					st = new StringTokenizer(br.readLine());
					for (int j = 0; j < w; j++) {
						map[i][j] = Integer.parseInt(st.nextToken());
					}
				}

				int count = 0;

				for (int i = 0; i < h; i++) {
					for (int j = 0; j < w; j++) {
						if (map[i][j] == 1 && !isChecked[i][j]) {
							dfs(i, j);
							count++;
						}
					}
				}

				sb.append(count).append('\n');
			}
		}
	}

	static void dfs(int row, int col) {

		isChecked[row][col] = true;

		for (int i = 0; i < 8; i++) {

			int nr = row + dir[i][0];
			int nc = col + dir[i][1];

			if (valid(nr, nc)) {
				dfs(nr, nc);
			}
		}
	}

	static boolean valid(int nr, int nc) {
		return nr < map.length && nc < map[0].length && nr >= 0 && nc >= 0 && !isChecked[nr][nc] && map[nr][nc] == 1;
	}
}
