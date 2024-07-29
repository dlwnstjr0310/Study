import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int[] arr = new int[9];
		int sum = 0;
		for (int i = 0; i < 9; i++) {
			int height = Integer.parseInt(br.readLine());
			arr[i] = height;
			sum += height;
		}

		sum -= 100;
		Arrays.sort(arr);

		int badHobbit = 0;
		int badHobbit2 = 0;
		for (int i = 0; i < arr.length; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[i] + arr[j] == sum) {
					badHobbit = arr[i];
					badHobbit2 = arr[j];
				}
			}
		}

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] != badHobbit && arr[i] != badHobbit2) {
				sb.append(arr[i]).append('\n');
			}
		}

		System.out.print(sb);
	}
}