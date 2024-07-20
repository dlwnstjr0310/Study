import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int[] arr = readLine(br);

		int a = Integer.parseInt(String.valueOf(new StringBuilder().append(arr[0]).reverse()));
		int b = Integer.parseInt(String.valueOf(new StringBuilder().append(arr[1]).reverse()));

		System.out.println(Math.max(a, b));
	}

	private static int[] readLine(BufferedReader br) throws IOException {
		return Arrays.stream(br.readLine().split(" "))
				.mapToInt(Integer::parseInt)
				.toArray();
	}
}