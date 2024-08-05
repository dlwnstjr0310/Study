import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {

	static int o, v, sheep, wolf;
	static char[][] map;
	static boolean[][] isVisited;
	static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

	public static void main(String[] args) throws IOException {

		/*
		 * 1. 입력 : 행의 수 R, 열의 수 C 가 주어지고, 이후 R 개의 줄에 울타리 '#', 평지 '.', 양 'o', 늑대 'v' 가 주어진다.
		 *
		 * 2. 기능 : 울타리 영역에서 o > v 면 영역 내부의 v를 제거하고, 이외의 경우에는 o를 제거한다.
		 * 2-1 : for문에서 map[i][j] == '#,.' 일때는 dfs,bfs 를 실행하지 않고 방문처리
		 * 2-2 : 이후 dfs,bfs 실행 중 map[i][j] 가 'o,v' 일 때 ++
		 * 2-3 : 순회가 끝나면 o,v 의 갯수를 비교해서 더 작은녀석을 제거해줌
		 * 2-4 : map[i][j] == '.' 일때도 방문처리로 했더니 오류가 발생해서 '.' 관련 구문을 제거해줌
		 *
		 * 3. 출력 : 살아남은 양과 늑대의 수를 출력
		 * */

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] split = br.readLine().split(" ");
		int R = Integer.parseInt(split[0]);
		int C = Integer.parseInt(split[1]);

		map = new char[R][C];
		isVisited = new boolean[R][C];

		for (int i = 0; i < R; i++) {
			map[i] = br.readLine().toCharArray();
		}

		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (map[i][j] == '#') {
					isVisited[i][j] = true;
				}
				if (!isVisited[i][j] && (map[i][j] == 'o' || map[i][j] == 'v')) {
					dfs(i, j);
//					bfs(i, j);
					if (o > 0 || v > 0) {
						sheep += o > v ? o : 0;
						wolf += o > v ? 0 : v;
						v = 0;
						o = 0;
					}
				}
			}
		}

		System.out.println(sheep + " " + wolf);
	}

	static void bfs(int row, int col) {

		isVisited[row][col] = true;
		Queue<int[]> q = new ArrayDeque<>();
		q.offer(new int[]{row, col});

		while (!q.isEmpty()) {
			int[] poll = q.poll();
			int currentRow = poll[0];
			int currentCol = poll[1];

			if (map[currentRow][currentCol] == 'o') {
				o++;
			}
			if (map[currentRow][currentCol] == 'v') {
				v++;
			}

			for (int i = 0; i < 4; i++) {
				int nr = currentRow + dir[i][0];
				int nc = currentCol + dir[i][1];

				if (valid(nr, nc)) {
					isVisited[nr][nc] = true;
					q.offer(new int[]{nr, nc});
				}
			}
		}
	}

	static void dfs(int row, int col) {

		isVisited[row][col] = true;

		if (map[row][col] == 'o') {
			o++;
		}
		if (map[row][col] == 'v') {
			v++;
		}

		for (int i = 0; i < 4; i++) {
			int nr = row + dir[i][0];
			int nc = col + dir[i][1];

			if (valid(nr, nc)) {
				dfs(nr, nc);
			}
		}

	}

	static boolean valid(int nr, int nc) {
		return nr < map.length && nc < map[0].length && nr >= 0 && nc >= 0 && !isVisited[nr][nc] && map[nr][nc] != '#';
	}
}
