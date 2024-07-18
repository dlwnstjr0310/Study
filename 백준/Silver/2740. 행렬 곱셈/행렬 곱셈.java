import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int[] input = readLine(br);

		int[][] arr = new int[input[0]][input[1]];

		for (int i = 0; i < input[0]; i++) {
			arr[i] = readLine(br);
		}

		int[] inputs = readLine(br);

		int[][] nextArr = new int[inputs[0]][inputs[1]];

		for (int i = 0; i < inputs[0]; i++) {
			nextArr[i] = readLine(br);
		}

		for (int i = 0; i < input[0]; i++) {
			for (int j = 0; j < inputs[1]; j++) {

				int sum = 0;

				for (int k = 0; k < input[1]; k++) {
					sum += arr[i][k] * nextArr[k][j];
				}
				sb.append(sum).append(' ');
			}
			sb.append('\n');
		}

		System.out.print(sb);
	}

	private static int[] readLine(BufferedReader br) throws IOException {
		return Arrays.stream(br.readLine().split(" "))
				.mapToInt(Integer::parseInt)
				.toArray();
	}
}