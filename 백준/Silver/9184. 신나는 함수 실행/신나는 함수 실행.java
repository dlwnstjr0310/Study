import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	static int[][][] storage = new int[21][21][21];

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		while (true) {
			int[] arr = readLine(br);
			int a = arr[0];
			int b = arr[1];
			int c = arr[2];

			if (a == -1 && b == -1 && c == -1) {
				break;
			} else {

				sb.append("w(")
						.append(a)
						.append(", ")
						.append(b)
						.append(", ")
						.append(c)
						.append(") = ")
						.append(w(a, b, c))
						.append('\n');
			}
		}
		System.out.println(sb);
	}

	private static int w(int a, int b, int c) {

		if (a <= 0 || b <= 0 || c <= 0) {
			return 1;
		}

		// 이미 값이 storage 에 있는 경우 계산 안함
		// storage 의 사이즈는 21인데, 그 이상의 수가 나올수도 있음.
		boolean rangeValidation = a <= 20 && b <= 20 && c <= 20;

		if (rangeValidation) {
			if (storage[a][b][c] != 0) {
				return storage[a][b][c];
			}
		} else {
			// a,b,c 중 하나라도 20보다 크다면 w (20,20,20) 을 실행
			// storage의 한계치인 [20] 에 저장해주기.
			return storage[20][20][20] = w(20, 20, 20);
		}

		if (a < b && b < c) {
			return storage[a][b][c] = w(a, b, c - 1) + w(a, b - 1, c - 1) - w(a, b - 1, c);
		}
		return storage[a][b][c] =
				w(a - 1, b, c) + w(a - 1, b - 1, c) + w(a - 1, b, c - 1) - w(a - 1, b - 1, c - 1);
	}

	private static int[] readLine(BufferedReader br) throws IOException {
		return Arrays.stream(br.readLine().split(" "))
				.mapToInt(Integer::parseInt)
				.toArray();
	}
}