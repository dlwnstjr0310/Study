import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class Main {

	static int[][] arr = new int[19][19];
	static StringBuilder sb = new StringBuilder();
	static boolean[] isSixStone = new boolean[4];

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int i = 0; i < 19; i++) {
			arr[i] = readLine(br);
		}

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				// 1이나 2의 전방위를 찾아보고 5개 연속 근처에 있으면 OK, 기록하기
				// i j 로 찾으면 왼쪽 위부터 쭉 찾으니까, 우측부터 좌하단까지 찾기
				if (arr[i][j] != 0) {
					findNumber(i, j);
				}
			}
		}

		if (sb.length() == 0) {
			System.out.println(0);
		} else {
			System.out.println(sb);
		}
	}

	private static void findNumber(int i, int j) {

		int count = 1;
		int target = arr[i][j];

		// 우 j + 1, 우하 i + 1 / j + 1 , 하 i + 1 , 좌하 i + 1 , j - 1
		if (j + 1 <= 18 && arr[i][j + 1] == target) {
			right(count + 1, i, j + 1);
		}
		if (i + 1 <= 18 && j + 1 <= 18 && arr[i + 1][j + 1] == target) {
			rightDown(count + 1, i + 1, j + 1);
		}
		if (i + 1 <= 18 && arr[i + 1][j] == target) {
			down(count + 1, i + 1, j);
		}
		if (i + 1 <= 18 && j - 1 >= 0 && arr[i + 1][j - 1] == target) {
			leftDown(count + 1, i + 1, j - 1);
		}
	}

	private static void right(int count, int i, int j) {
		int target = arr[i][j];

		if (count == 5 && sb.length() == 0 && !isSixStone[0]) {

			if (j < 18 && arr[i][j + 1] == target) {
				isSixStone[0] = true;
				return;
			} else {
				Map<String, String> map = new HashMap<>();
				for (int k = 0; k <= 4; k++) {
					map.put(Integer.toString(j - k), Integer.toString(i));
				}

				String key = map.keySet().stream().min(Comparator.comparing(Integer::parseInt)).get();

				sb.append(arr[i][j])
						.append('\n')
						.append(Integer.parseInt(map.get(key)) + 1)
						.append(' ')
						.append(Integer.parseInt(key) + 1);
			}
		} else {
			if (j + 1 <= 18 && arr[i][j + 1] == target) {
				right(count + 1, i, j + 1);
			}
		}
	}

	private static void rightDown(int count, int i, int j) {
		int target = arr[i][j];

		if (count == 5 && sb.length() == 0 && !isSixStone[1]) {
			if (i < 18 && j < 18 && arr[i + 1][j + 1] == target) {
				isSixStone[1] = true;
			} else {
				Map<String, String> map = new HashMap<>();

				for (int k = 0; k <= 4; k++) {
					map.put(Integer.toString(i - k), Integer.toString(j - k));
				}

				String key = map.keySet().stream().min(Comparator.comparing(Integer::parseInt)).get();

				sb.append(arr[i][j])
						.append('\n')
						.append(Integer.parseInt(key) + 1)
						.append(' ')
						.append(Integer.parseInt(map.get(key)) + 1);
			}
		} else {
			if (i + 1 <= 18 && j + 1 <= 18 && arr[i + 1][j + 1] == target) {
				rightDown(count + 1, i + 1, j + 1);
			}
		}
	}

	private static void down(int count, int i, int j) {
		int target = arr[i][j];

		if (count == 5 && sb.length() == 0 && !isSixStone[2]) {

			if (i < 18 && arr[i + 1][j] == target) {
				isSixStone[2] = true;
			} else {

				Map<String, String> map = new HashMap<>();
				for (int k = 0; k <= 4; k++) {
					map.put(Integer.toString(i - k), Integer.toString(j));
				}
				String key = map.keySet().stream().min(Comparator.comparing(Integer::parseInt)).get();

				sb.append(arr[i][j])
						.append('\n')
						.append(Integer.parseInt(key) + 1)
						.append(' ')
						.append(Integer.parseInt(map.get(key)) + 1);
			}
		} else {
			if (i + 1 <= 18 && arr[i + 1][j] == target) {
				down(count + 1, i + 1, j);
			}
		}
	}

	private static void leftDown(int count, int i, int j) {
		int target = arr[i][j];

		if (count == 5 && sb.length() == 0 && !isSixStone[3]) {

			if (i < 18 && j > 0 && arr[i + 1][j - 1] == target) {
				isSixStone[3] = true;
			} else {
				Map<String, String> map = new HashMap<>();
				for (int k = 0; k <= 4; k++) {
					map.put(Integer.toString(i - k), Integer.toString(j + k));
				}

				String key = map.keySet().stream().max(Comparator.comparing(Integer::parseInt)).get();

				sb.append(arr[i][j])
						.append('\n')
						.append(Integer.parseInt(key) + 1)
						.append(' ')
						.append(Integer.parseInt(map.get(key)) + 1);
			}
		} else {
			if (i + 1 <= 18 && j - 1 >= 0 && arr[i + 1][j - 1] == target) {
				leftDown(count + 1, i + 1, j - 1);
			}
		}
	}

	private static int[] readLine(BufferedReader br) throws IOException {
		return Arrays.stream(br.readLine().split(" "))
				.mapToInt(Integer::parseInt)
				.toArray();
	}
}