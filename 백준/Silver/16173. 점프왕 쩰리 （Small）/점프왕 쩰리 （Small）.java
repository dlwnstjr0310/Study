import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		/*
		 * 1. 쩰리는 정사각형 외부로 나가는경우 죽는다
		 * 2. 시작점은 항상 왼쪽 위 (0,0)
		 * 3. 우하단으로만 이동 가능
		 * 4. 6x6 일 경우 5,5 에 도착하면 쩰리의 승리
		 * 5. 한 번에 이동할 수 있는 칸은 정확히 현재 칸에 적혀있는 숫자만큼. 초과나 그 미만으로 이동할 수 없다.
		 * */
		int num = Integer.parseInt(br.readLine());
		int[][] map = new int[num][num];
		boolean[][] isVisited = new boolean[num][num];

		for (int i = 0; i < num; i++) {
			map[i] = Arrays.stream(br.readLine().split(" "))
					.mapToInt(Integer::parseInt)
					.toArray();
		}

		dfs(0, 0, map, isVisited);
		System.out.println("Hing");
	}

	private static void dfs(int row, int col, int[][] map, boolean[][] isVisited) {

		if (map[row][col] == -1) {
			System.out.println("HaruHaru");
			System.exit(0);
		}
		if (isVisited[row][col] || map[row][col] == 0) {
			return;
		} else {
			int nc = col + map[row][col];
			int nr = row + map[row][col];

			if (nc < map.length && !isVisited[row][nc]) {
				dfs(row, nc, map, isVisited);
			}

			if (nr < map.length && !isVisited[nr][col]) {
				dfs(nr, col, map, isVisited);
			}
		}
		isVisited[row][col] = true;
	}
}
