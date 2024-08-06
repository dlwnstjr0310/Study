import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

	static int R, C;
	static int[][] map;
	static boolean[][] isChecked;
	static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] split = br.readLine().split(" ");

		R = Integer.parseInt(split[0]);
		C = Integer.parseInt(split[1]);

		map = new int[R][C];
		isChecked = new boolean[R][C];

		for (int i = 0; i < R; i++) {
			split = br.readLine().split(" ");
			for (int j = 0; j < C; j++) {
				map[i][j] = Integer.parseInt(split[j]);
			}
		}

		int year = 0;
		while (true) {

			int count = countIce();

			if (count >= 2) {
				break;
			} else if (count == 0) {
				year = 0;
				break;
			}

			meltIce();
			year++;
		}

		System.out.println(year);
	}

	static int countIce() {

		int count = 0;
		boolean[][] isChecked = new boolean[R][C];

		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (!isChecked[i][j] && map[i][j] > 0) {
					dfs(i, j, isChecked);
					count++;
				}
			}
		}

		return count;
	}

	static void dfs(int row, int col, boolean[][] isChecked) {

		isChecked[row][col] = true;

		for (int i = 0; i < 4; i++) {
			int nr = row + dir[i][0];
			int nc = col + dir[i][1];

			if (valid(nr, nc) && map[nr][nc] > 0 && !isChecked[nr][nc]) {
				dfs(nr, nc, isChecked);
			}
		}
	}

	static void meltIce() {

		List<int[]> list = new ArrayList<>();

		for (int row = 0; row < R; row++) {
			for (int col = 0; col < C; col++) {

				int count = 0;

				if (map[row][col] > 0) {

					for (int k = 0; k < 4; k++) {
						int nr = row + dir[k][0];
						int nc = col + dir[k][1];

						if (valid(nr, nc) && map[nr][nc] == 0) {
							count++;
						}
					}
				}
				for (int i = 0; i < count; i++) {
					list.add(new int[]{row, col});
				}
			}
		}

		for (int[] arr : list) {
			if (map[arr[0]][arr[1]] > 0) {
				map[arr[0]][arr[1]] -= 1;
			}
		}

	}

	static boolean valid(int nr, int nc) {
		return nr < map.length && nc < map[0].length && nr >= 0 && nc >= 0;
	}
}