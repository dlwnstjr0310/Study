import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int[] arr = readLine(br);

		Set<String> set = new HashSet<>();

		for (int i = 0; i < arr[0]; i++) {
			String str = br.readLine();

			set.add(str);
		}

		for (int i = 0; i < arr[1]; i++) {

			StringTokenizer st = new StringTokenizer(br.readLine(), ",");
			int tokens = st.countTokens();

			for (int j = 0; j < tokens; j++) {
				set.remove(st.nextToken());
			}
			sb.append(set.size()).append('\n');
		}

		System.out.print(sb);
	}

	private static int[] readLine(BufferedReader br) throws IOException {
		return Arrays.stream(br.readLine().split(" "))
				.mapToInt(Integer::parseInt)
				.toArray();
	}
}