import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static char[][] way;
	static boolean[][] isChecked;
	static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

	public static void main(String[] args) throws IOException {

		/*
		 * 1. 입력 : 첫 줄에 통로 세로 길이 N, 통로 가로 길이 M, 음식물의 갯수 K 가 주어진다.
		 *          이후 K개의 줄에 음식물의 좌표가 입력되는데, -1 씩 해서 사용해야 한다.
		 *
		 * 2. 기능 : 음식물끼리는 상하좌우를 감지하여 합체한다. 가장 큰 음식물의 크기를 구하자.
		 *
		 * 3. 출력 : 가장 큰 음식물쓰레기의 크기
		 * */

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		way = new char[N][M];
		isChecked = new boolean[N][M];

		for (int i = 0; i < K; i++) {
			String[] split = br.readLine().split(" ");

			int x = Integer.parseInt(split[0]) - 1;
			int y = Integer.parseInt(split[1]) - 1;

			way[x][y] = '#';
		}

		int size = 0;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (way[i][j] == '#' && !isChecked[i][j]) {
//					size = Math.max(dfs(i, j), size);
					size = Math.max(bfs(i, j), size);
				}
			}
		}

		System.out.println(size);
	}

	static int bfs(int row, int col) {

		int count = 1;
		isChecked[row][col] = true;

		Queue<int[]> q = new ArrayDeque<>();
		q.offer(new int[]{row, col});

		while (!q.isEmpty()) {
			int[] poll = q.poll();

			for (int i = 0; i < 4; i++) {
				int nr = poll[0] + dir[i][0];
				int nc = poll[1] + dir[i][1];

				if (valid(nr, nc)) {
					q.offer(new int[]{nr, nc});
					isChecked[nr][nc] = true;
					count++;
				}
			}
		}

		return count;
	}

	static int dfs(int row, int col) {

		int count = 1;
		isChecked[row][col] = true;

		for (int i = 0; i < 4; i++) {

			int nr = row + dir[i][0];
			int nc = col + dir[i][1];

			if (valid(nr, nc)) {
				count += dfs(nr, nc);
			}
		}

		return count;
	}

	static boolean valid(int nr, int nc) {
		return nr < way.length && nc < way[0].length && nr >= 0 && nc >= 0 && !isChecked[nr][nc] && way[nr][nc] == '#';
	}

}
