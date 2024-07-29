import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static char[][] arr;
	static boolean[][] visited;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] str = br.readLine().split(" ");

		int row = Integer.parseInt(str[0]);
		int col = Integer.parseInt(str[1]);

		arr = new char[row][col];
		visited = new boolean[row][col];

		for (int i = 0; i < row; i++) {
			String target = br.readLine();
			arr[i] = target.toCharArray();
		}

		int count = 0;
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (arr[i][j] == '#' && !visited[i][j]) {
					count++;
					find(i, j);
				}
			}
		}

		System.out.println(count);

	}

	private static void find(int row, int col) {

		if (arr[row][col] == '#' && !visited[row][col]) {
			visited[row][col] = true;

			if (row + 1 < arr.length) {
				find(row + 1, col);
			}
			if (row - 1 > 0) {
				find(row - 1, col);
			}
			if (col - 1 > 0) {
				find(row, col - 1);
			}
			if (col + 1 < arr[0].length) {
				find(row, col + 1);
			}
		}
	}
}