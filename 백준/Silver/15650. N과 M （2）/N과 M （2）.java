import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	static int[] arr;
	static int N;
	static int M;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int[] array = readLine(br);

		N = array[0];
		M = array[1];
		arr = new int[M];

		if (M == 1) {
			for (int i = 0; i < N; i++) {
				sb.append(i + 1).append('\n');
			}
		} else {
			calculrator(1, 0);
		}

		System.out.print(sb);
	}

	private static void calculrator(int index, int count) {
		if (M == count) {
			for (int i : arr) {
				sb.append(i).append(' ');
			}
			sb.append('\n');
		} else {
			for (int i = index; i <= N; i++) {
				arr[count] = i;
				calculrator(i + 1, count + 1);
			}
		}
	}

	private static int[] readLine(BufferedReader br) throws IOException {
		return Arrays.stream(br.readLine().split(" "))
				.mapToInt(Integer::parseInt)
				.toArray();
	}
}