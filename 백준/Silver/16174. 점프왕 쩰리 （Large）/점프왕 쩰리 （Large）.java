import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static int N;
	static int[][] map;
	static boolean[][] isVisited;

	public static void main(String[] args) throws IOException {

		/*
		 * 1. 입력 : 사이즈 N , 두번째줄부터 마지막줄까지 게임판의 정보가 주어짐.
		 *          오른쪽 구석은 -1 이고, 나머지는 0 ~ 100 까지으 ㅣ정수가 적혀있다
		 *
		 * 2. 기능 : {0,0} 에서 시작해 {N-1,N-1} 까지 가야함!
		 * 2-1. : 아마.. 저번처럼 게임판 만들어서 푸는거 아닐까? isVisited 랑,,, map 을 준비하자
		 *
		 * 3. 출력 : {N-1,N-1} 에 도착하면 "HaruHaru", 못하면 "Hing"
		 * */

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		isVisited = new boolean[N][N];

		for (int i = 0; i < N; i++) {
			String[] split = br.readLine().split(" ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(split[j]);
			}
		}

		dfs(0, 0);

		System.out.print("Hing");
	}

	static void dfs(int row, int col) {

		isVisited[row][col] = true;
		int step = map[row][col];

		if (step == -1) {
			System.out.print("HaruHaru");
			System.exit(0);
		}

		int nr = row + step;
		int nc = col + step;

		if (nr >= 0 && nr < N && !isVisited[nr][col]) {
			dfs(nr, col);
		}
		if (nc >= 0 && nc < N && !isVisited[row][nc]) {
			dfs(row, nc);
		}
	}
}