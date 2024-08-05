import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static int N;
	static boolean[][] isChecked;
	static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

	public static void main(String[] args) throws IOException {

		/*
		 * 1. 입력 : 그리드의 크기 N, 칸의 정보 R,G,B 중 1개
		 *
		 * 2. 기능 : 일반인이 보는 그림의 색 갯수와 적록색약이 보는 그림의 색 갯수를 구해야함.
		 *
		 * 3. 출력 : 일반인 기준 색 갯수 + " " + 적록색약 기준 색 갯수
		 * */

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		char[][] map = new char[N][N];
		char[][] colorWeaknessMap = new char[N][N];

		for (int i = 0; i < N; i++) {
			char[] charArray = br.readLine().toCharArray();
			map[i] = charArray;

			for (int j = 0; j < charArray.length; j++) {
				char c = charArray[j];
				if (c == 'G') {
					c = 'R';
				}
				colorWeaknessMap[i][j] = c;
			}
		}

		int normalPersonCount = getCount(map);
		int colorWeaknessPersonCount = getCount(colorWeaknessMap);

		System.out.println(normalPersonCount + " " + colorWeaknessPersonCount);
	}

	private static int getCount(char[][] map) {

		int count = 0;
		isChecked = new boolean[N][N];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {

				if (!isChecked[i][j]) {
					dfs(i, j, map);
					count++;
				}
			}
		}
		return count;
	}

	static void dfs(int row, int col, char[][] map) {
		isChecked[row][col] = true;

		for (int i = 0; i < 4; i++) {
			int nr = row + dir[i][0];
			int nc = col + dir[i][1];

			if (valid(nr, nc, map[row][col], map)) {
				dfs(nr, nc, map);
			}
		}

	}

	static boolean valid(int nr, int nc, char c, char[][] map) {
		return nr < map.length && nc < map[0].length && nr >= 0 && nc >= 0 && !isChecked[nr][nc] && c == map[nr][nc];
	}
}