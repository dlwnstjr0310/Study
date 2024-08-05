import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N, M;
	static String answer = "NO";
	static char[][] map;
	static boolean[][] isVisited;
	static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

	public static void main(String[] args) throws IOException {

		/*
		 * 1. 입력 : 세로 크기 M , 가로 크기 N, 전류가 통하는 공간인 0 과 통하지 않는 공간인 1이 주어진다.
		 *
		 * 2. 기능 : (0,x) 에서 공급된 전류가 (M,x) 로 갈 수 있는지 확인
		 *
		 * 3. 출력 : 전류가 (M,x) 에 도달할 수 있다면 YES, 아니라면 NO 를 출력한다.
		 * */

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());

		map = new char[M][N];
		isVisited = new boolean[M][N];

		for (int i = 0; i < M; i++) {
			map[i] = br.readLine().toCharArray();
		}

		for (int i = 0; i < 1; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == '1') {
					isVisited[i][j] = true;
				} else if (map[i][j] == '0' && !isVisited[i][j]) {
					dfs(i, j);
				}
			}
		}
		System.out.println(answer);
	}

	static void dfs(int row, int col) {

		isVisited[row][col] = true;

		if (row + 1 == M) {
			answer = "YES";
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
		return nr < map.length && nc < map[0].length && nr >= 0 && nc >= 0 && !isVisited[nr][nc] && map[nr][nc] == '0';
	}
}
