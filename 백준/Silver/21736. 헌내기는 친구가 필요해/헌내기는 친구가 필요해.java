import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static int count = 0;
	static char[][] map;
	static boolean[][] isVisited;
	static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] split = br.readLine().split(" ");
		int N = Integer.parseInt(split[0]);
		int M = Integer.parseInt(split[1]);
		map = new char[N][M];
		isVisited = new boolean[N][M];

		/*
		 * 1. 입력 : 세로 N , 가로 M
		 *          O 는 빈공간, X 는 벽, P 가 사람임. P 를 만날때마다 체크해주기
		 * -> 배치 정보를 저장할 이차원배열 map 생성, 방향을 기록한 dir 생성
		 *
		 * 2. 기능 : I가 출발지점이고, 상하좌우 이동하면서 P를 몇개 만나는지 체크
		 * -> 벽은 넘어갈 수 없음.
		 *
		 * 3. 출력 : I가 현재 위치에서 P를 몇번이나 만날 수 있는지?
		 * */

		for (int i = 0; i < N; i++) {
			map[i] = br.readLine().toCharArray();
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 'I') {
					dfs(i, j);
				}
			}
		}

		System.out.println(count > 0 ? count : "TT");
	}

	static void dfs(int row, int col) {

		for (int i = 0; i < 4; i++) {

			int nr = row + dir[i][0];
			int nc = col + dir[i][1];
			boolean valid = 0 <= nr && nr < map.length && 0 <= nc && nc < map[0].length && !isVisited[nr][nc] && map[nr][nc] != 'X';

			if (valid) {
				isVisited[nr][nc] = true;
				if (map[nr][nc] == 'P') {
					count++;
				}
				dfs(nr, nc);
			}
		}
	}
}
