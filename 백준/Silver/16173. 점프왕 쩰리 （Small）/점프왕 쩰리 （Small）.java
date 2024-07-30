import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static int[][] map;
	static boolean[][] isVisited;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int num = Integer.parseInt(br.readLine());

		map = new int[num][num];
		isVisited = new boolean[num][num];

		for (int i = 0; i < num; i++) {
			String[] split = br.readLine().split(" ");
			for (int j = 0; j < num; j++) {
				map[i][j] = Integer.parseInt(split[j]);
			}
		}

		dfs(0, 0);

		System.out.println("Hing");
	}

	static void dfs(int row, int col) {

		isVisited[row][col] = true;
		int step = map[row][col];

		if (step == -1) {
			System.out.println("HaruHaru");
			System.exit(0);
		}

		int nr = row + step;
		int nc = col + step;

		if (nr < map.length && !isVisited[nr][col]) {
			dfs(nr, col);
		}
		if (nc < map.length && !isVisited[row][nc]) {
			dfs(row, nc);
		}

	}
}