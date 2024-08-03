import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int[][] map;
	static boolean[][] isChecked;
	static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

	public static void main(String[] args) throws IOException {

		/*
		 * 1. 입력 : 세로크기 n , 가로크기 m
		 *          이후 n+1 줄까지 그림의 정보. 1은 색칠, 0은 색칠안한거
		 *
		 * 2. 기능 :
		 * 2.1 : 상하좌우 검사해서 연결되어있으면 count + 1 해주기
		 * 2.2 : 연결되어 있는 1의 갯수를 카운트해서 max 변수에 담기
		 *
		 * 3. 출력 : 총 그림의 갯수 \n 가장 큰 그림의 넓이
		 * */

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		map = new int[n][m];
		isChecked = new boolean[n][m];

		int count = 0;

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int max = 0;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (!isChecked[i][j] && map[i][j] == 1) {
					count++;
					max = Math.max(dfs(i, j, 1), max);
				}
			}
		}

		sb.append(count)
				.append('\n')
				.append(max);

		System.out.println(sb);
	}

	static int dfs(int row, int col, int count) {

		isChecked[row][col] = true;
		int maxSize = 1;

		for (int i = 0; i < 4; i++) {
			int nr = row + dir[i][0];
			int nc = col + dir[i][1];

			if (valid(nr, nc)) {
				maxSize += dfs(nr, nc, count + 1);
			}
		}

		return maxSize;
	}

	static boolean valid(int nr, int nc) {
		return nr < map.length && nc < map[0].length && nr >= 0 && nc >= 0 && !isChecked[nr][nc] && map[nr][nc] == 1;
	}

}
