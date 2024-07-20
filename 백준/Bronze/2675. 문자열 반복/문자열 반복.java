import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int num = Integer.parseInt(br.readLine());

		for (int i = 0; i < num; i++) {

			StringTokenizer st = new StringTokenizer(br.readLine());

			int repeat = Integer.parseInt(st.nextToken());
			String str = st.nextToken();

			for (int j = 0; j < str.length(); j++) {

				for (int k = 0; k < repeat; k++) {
					sb.append(str.charAt(j));
				}
			}
			sb.append('\n');
		}

		System.out.println(sb);
	}

	private static int[] readLine(BufferedReader br) throws IOException {
		return Arrays.stream(br.readLine().split(" "))
				.mapToInt(Integer::parseInt)
				.toArray();
	}
}