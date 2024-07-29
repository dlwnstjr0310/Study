import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static boolean[][] isVisited;
	static char[][] room;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] split = br.readLine().split(" ");
		int row = Integer.parseInt(split[0]);
		int col = Integer.parseInt(split[1]);

		isVisited = new boolean[row][col];
		room = new char[row][col];

		for (int i = 0; i < row; i++) {
			room[i] = br.readLine().toCharArray();
		}

		int cnt = 0;

		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (!isVisited[i][j]) {
					if (room[i][j] == '-') {
						dfs(i, j, true);
					} else if (room[i][j] == '|') {
						dfs(i, j, false);
					}
					cnt++;
				}
			}
		}
		System.out.println(cnt);
	}

	private static void dfs(int x, int y, boolean isRow) {

		isVisited[x][y] = true;

		if (isRow) {
			int ny = y + 1;
			if (ny < room[0].length && room[x][ny] == '-') {
				dfs(x, ny, true);
			}
		} else {
			int nx = x + 1;
			if (nx < room.length && room[nx][y] == '|') {
				dfs(nx, y, false);
			}
		}
	}
}