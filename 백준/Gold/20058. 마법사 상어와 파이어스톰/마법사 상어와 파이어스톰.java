import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static int N, Q, POW;
	static int[][] map;
	static int[][] copy;
	static boolean[][] isChecked;
	static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

	public static void main(String[] args) throws IOException {

		/*
		 * 1. 입력 : 첫 줄에 격자의 크기 N , 시전횟수 Q 가 주어진다.
		 *          이후 2^N 개의 줄에 격자의 각 칸에 있는 얼음의 양이 주어지고, 마지막 줄에 단계 L 이 주어진다.
		 *
		 * 2. 기능 : 파이어스톰을 시전할때마다 단계 L 을 정해야하는데, 과정은 다음과 같다.
		 *          1. 격자를 2^L 크기로 나누고, 모든 격자를 시계방향으로 90도 회전시킨다.
		 *          2. 이후 얼음이 있는 칸 3개 이상과 인접해있지 않은 칸은 얼음의 양이 1 줄어든다.
		 *          -> A(r,c)칸 상하좌우에 얼음없는 칸이 2개 이상일 경우 에 줄어드는거임
		 *          -> 예제 1번의 경우 꼭지점 4개가 1씩 줄어들어서 288-4 로 284임. 이부분 이해하는데 한시간걸렸네;
		 * 2-1 : 배열을 시계방향으로 회전시켜야함. 공식을 구해보자
		 * -> 신규 row : 기존 col
		 * -> 신규 col : 메소드 실행 횟수로 쓸수있지않을까? 1,0 / 1,1 -> 0,0 / 1,0 이니까..
		 * => 못하겠어서 구글링해서 긁어옴
		 *
		 * 2-2 : 기존 배열을 바로 바꿀 수 없으니까, 배열 사본이 하나 필요하다.
		 * -> copy 썼더니 동기화되어서 따로 입력해주어야할듯
		 *
		 * 2-3 : 상하좌우에 얼음이 2개이상 없는녀석들은 -1 씩 해주자. 이것도 진행하면서 변경하면 안되니까, 담아뒀다 한번에 해야함
		 * 2-4 : 하란대로 다 적었는데 얼음을 녹이는 부분은 잘 작동하는데, 값이 copy 에 반영되지 않는다. 뭐때문이지?
		 * -> copy 를 녹여놓고 rotate 메소드에서 새걸로 입력해주고있었음; rotate 메소드 실행하고 map에 다시 덮어씌워야함
		 *
		 * 2-5 : 예제 3번부터 값이 이상하다. 얼음이 0이 되는 경우가 생김. 뭐지?
		 * 2-6 : meltIce 랑 isValid에 POW 가 아니라 N 을 적어놨었다; 처음부터 하나씩 적으니까 이런일이
		 * 2-7 : 틀리길래 뭔가 하고 봤더니 예제 6번은 값이 안맞는다. 뭐지
		 * -> map[i][j] > 0일때만 검사를 하기때문에 0을 만나면 검사를 중단하고, 그때마다 isChecked 배열이 다시 생기기때문에
		 *    얘도 마찬가지로 Math.max() 를 사용해주어야함.
		 *
		 * 3. 출력 : 첫 줄에 얼음의 총 갯수, 둘째줄에 가장 큰 덩어리가 차지하는 칸의 갯수 출력
		 * */

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		Q = Integer.parseInt(st.nextToken());

		POW = (int) Math.pow(2, N);
		map = new int[POW][POW];

		for (int i = 0; i < POW; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < POW; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		st = new StringTokenizer(br.readLine());

		while (Q > 0) {
			int num = Integer.parseInt(st.nextToken());
			int divide = (int) Math.pow(2, num);

			copy = new int[POW][POW];

			for (int i = 0; i < POW; i += divide) {
				for (int j = 0; j < POW; j += divide) {
					rotate(i, j, divide);
				}
			}

			map = copy;
			meltIce();
			Q--;
		}

		int sum = 0;
		int count = 0;
		isChecked = new boolean[map.length][map.length];

		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map.length; j++) {
				sum += map[i][j];

				if (map[i][j] > 0 && !isChecked[i][j]) {
					count = Math.max(dfs(i, j), count);
				}
			}
		}

		sb.append(sum)
				.append('\n')
				.append(count);
		System.out.print(sb);
	}

	static int dfs(int row, int col) {

		int innerCount = 1;
		isChecked[row][col] = true;

		for (int i = 0; i < 4; i++) {
			int nr = row + dir[i][0];
			int nc = col + dir[i][1];

			if (valid(nr, nc)) {
				if (!isChecked[nr][nc]) {
					innerCount += dfs(nr, nc);
				}
			}
		}

		return innerCount;
	}

	static void meltIce() {

		//여기서는 칸 하나가 주위에 얼음이 2개 이상 있는지 확인하고, 없으면 녹일거임.
		List<int[]> list = new ArrayList<>();

		for (int i = 0; i < POW; i++) {
			for (int j = 0; j < POW; j++) {

				int count = 0;

				if (map[i][j] > 0) {

					for (int k = 0; k < 4; k++) {

						int nr = i + dir[k][0];
						int nc = j + dir[k][1];

						if (valid(nr, nc)) {
							count++;
						}

					}

					if (count < 3) {
						list.add(new int[]{i, j});
					}
				}
			}
		}

		for (int[] arr : list) {
			map[arr[0]][arr[1]] -= 1;
		}
	}


	static void rotate(int row, int col, int divide) {

		int nr = row + divide;
		int nc = col + divide;

		for (int i = row; i < nr; i++) {
			int count = 0;
			for (int j = col; j < nc; j++) {
				copy[i][j] = map[nr - 1 - count][divide - (nr - i) + col];
				count++;
			}
		}
	}

	static boolean valid(int nr, int nc) {
		return nr >= 0 && nc >= 0 && nr < POW && nc < POW && map[nr][nc] > 0;
	}
}
