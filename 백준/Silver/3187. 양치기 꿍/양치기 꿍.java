import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	static char[][] map;
	static boolean[][] isChecked;
	static int sheep = 0;
	static int wolf = 0;
	static int k = 0;
	static int v = 0;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] split = br.readLine().split(" ");

		int row = Integer.parseInt(split[0]);
		int col = Integer.parseInt(split[1]);

		map = new char[row][col];
		isChecked = new boolean[row][col];

		for (int i = 0; i < row; i++) {
			map[i] = br.readLine().toCharArray();
		}

		/*
		 * 1. 울타리 영역에서 상하좌우 돌아다니면서 늑대랑 양 찾기 -> dfs 이용
		 * 2. 더이상 돌아다닐 곳이 없을 때 dfs 종료됨 -> 늑대랑 양 다 찾음
		 * 3. 늑대랑 양 갯수 비교해서 저장하기
		 * */
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (!isChecked[i][j]) {
					dfs(i, j);
					if (k > 0 || v > 0) {
						if (k > v) {
							v = 0;
							sheep += k;
							k = 0;
						} else {
							k = 0;
							wolf += v;
							v = 0;
						}
					}
				}
			}
		}

		System.out.println(sheep + " " + wolf);
	}

	static void dfs(int row, int col) {

		if (!isChecked[row][col]) {

			isChecked[row][col] = true;

			// k 가 양임
			if (map[row][col] == '#') {
				return;
			} else if (map[row][col] == 'k') {
				k++;
			} else if (map[row][col] == 'v') {
				v++;
			}

			for (int i = 0; i < 4; i++) {

				int nr = row + dr[i];
				int nc = col + dc[i];

				if (nr < map.length && nr >= 0 &&
						nc < map[0].length && nc >= 0 &&
						map[nr][nc] != '#' &&
						!isChecked[nr][nc]) {
					dfs(nr, nc);
				}

			}

		}

	}
}
