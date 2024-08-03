import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static int[][] map;
	static boolean[][] isChecked;
	static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

	public static void main(String[] args) throws IOException {

		/*
		 * 1. 입력 : 첫번째줄에는 맵 크기 N , 버섯 포자 M , 버섯 포자의 상태 K
		 *          1 <= N <= 100, 0 <= M <= 1_000_000 , 1 <= K <= 10^8
		 *          둘째줄부터 N 개의 줄에 나무판의 상태
		 *          0 은 버섯이 자랄 수 있는 칸, 1은 버섯이 자랄 수 없는 칸임!!! 1이 없는칸!!!!!
		 *
		 * 2. 기능 : 탐색하는데, 버섯 포자보다 0이 많으면 탐색 안해도된다!
		 * 2-1 : 방문여부 확인할 isChecked, 방향정보인 dir 생성
		 * 2-2 : 이중for문에서 map[i][j] 가 1 이면 isChecked true, 0이면 dfs 실행
		 * 2-3 : 재배할 수 있는 땅을 기록하기위해 dfs 에서 사이즈를 리턴하고, list 에 담아주기
		 * 2-4 : 땅의 범위에서 포자의 확산범위를 계속 빼면서 땅에 몇개의 포자를 사용해야 하는지 체크
		 *
		 * 3. 출력 : 버섯농사 가능/불가능 여부와 남은 버섯 포자의 개수
		 * */

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int spore = Integer.parseInt(st.nextToken());
		int diffusionRange = Integer.parseInt(st.nextToken());

		map = new int[N][N];
		isChecked = new boolean[N][N];

		for (int i = 0; i < N; i++) {
			String[] split = br.readLine().split(" ");
			for (int j = 0; j < N; j++) {
				int target = split[j].charAt(0) - 48;
				map[i][j] = target;
			}
		}

		List<Integer> list = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 1) {
					isChecked[i][j] = true;
				} else if (!isChecked[i][j]) {
					list.add(dfs(i, j));
				}
			}
		}

		int sporeCount = 0;

		for (int target : list) {
			while (target > 0) {
				target -= diffusionRange;
				sporeCount++;
			}
		}

		if (sporeCount > spore || spore == 0 || sporeCount == 0) {
			sb.append("IMPOSSIBLE");
		} else  {
			sb.append("POSSIBLE")
					.append('\n')
					.append(spore - sporeCount);
		} 

		System.out.print(sb);
	}

	static int dfs(int row, int col) {

		isChecked[row][col] = true;
		int size = 1;
		for (int i = 0; i < 4; i++) {
			int nr = row + dir[i][0];
			int nc = col + dir[i][1];

			if (valid(nr, nc)) {
				size += dfs(nr, nc);
			}
		}

		return size;
	}

	static boolean valid(int nr, int nc) {
		return nr < map.length && nc < map[0].length && nr >= 0 && nc >= 0 && !isChecked[nr][nc] && map[nr][nc] == 0;
	}
}
