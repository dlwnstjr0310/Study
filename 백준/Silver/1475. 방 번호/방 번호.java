import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		String str = br.readLine();

		int[] arr = new int[10];

		for (int i = 0; i < str.length(); i++) {
			int n = Integer.parseInt(String.valueOf(str.charAt(i)));
			if (n == 9) {
				arr[6]++;
			} else {
				arr[n]++;
			}
		}

		if (arr[6] % 2 == 1) {
			arr[6] = (arr[6] / 2) + 1;
		} else {
			arr[6] = arr[6] / 2;
		}

		int max = 0;

		for (int j : arr) {
			max = Math.max(max, j);
		}

		System.out.println(max);

	}
}