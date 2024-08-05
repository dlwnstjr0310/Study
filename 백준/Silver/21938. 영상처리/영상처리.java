import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int T;
	static int[][] map;
	static boolean[][] isChecked;
	static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

	public static void main(String[] args) throws IOException {
		/*
		 * 1. 입력 : 화면의 세로 N, 가로 M 값이 주어지고 이후 N 개의 줄에 N*3 개의 RGB 값이 주어지고, 마지막 줄에 경계값 T 가 주어진다.
		 *          N*3개의 RGB 값의 평균이 T 이하이면 0으로,이상이면 255로 저장하고, RGB 값이 255라면 물체로 인식한다.
		 *
		 * 2. 기능 : T 값을 전달받아 RGB 값을 평균내어 물체의 갯수를 구하고, 상하좌우 검사해야함.
		 * 2-1 : RGB 값의 평균을 구하기 위한 List 생성, 위치를 기억해야 하기 때문에 구현체는 LinkedList 로 한다.
		 * 2-2 : List의 값을 map에 저장해야하므로 x축은 index / M  으로, y축은 i % M 으로 구하여 입력해준다.
		 * 2-3 : 시간초과받음. 아마 리스트를 사용하면 안되나보다 ㅠ
		 * 2-4 : 리스트 제거하고 valid 에 T 조건을 추가
		 *
		 * 3. 출력 : 화면에 있는 물체의 개수를 출력하기
		 * */

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		isChecked = new boolean[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());

			for (int j = 0; j < M; j++) {
				int R = Integer.parseInt(st.nextToken());
				int G = Integer.parseInt(st.nextToken());
				int B = Integer.parseInt(st.nextToken());
				int sum = (R + G + B) / 3;

				map[i][j] = sum;
			}
		}

		// 얘보다 크거나 같으면 255로
		T = Integer.parseInt(br.readLine());

		int answer = 0;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (!isChecked[i][j]) {
					if (map[i][j] >= T) {
						dfs(i, j);
						answer++;
					} else {
						isChecked[i][j] = true;
					}
				}
			}
		}

		System.out.println(answer);
	}

	static void dfs(int row, int col) {

		isChecked[row][col] = true;

		for (int i = 0; i < 4; i++) {

			int nr = row + dir[i][0];
			int nc = col + dir[i][1];

			if (valid(nr, nc)) {
				dfs(nr, nc);
			}
		}

	}

	static boolean valid(int nr, int nc) {
		return nr < map.length && nc < map[0].length && nr >= 0 && nc >= 0 && !isChecked[nr][nc] && map[nr][nc] >= T;
	}
}
