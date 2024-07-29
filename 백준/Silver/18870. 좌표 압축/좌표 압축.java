import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int num = Integer.parseInt(br.readLine());
		Map<Integer, Integer> map = new HashMap<>();
		int[] str = Arrays.stream(br.readLine().split(" "))
				.mapToInt(Integer::parseInt)
				.toArray();
		int[] clone = str.clone();
		Arrays.sort(str);

		for (int i = 0; i < num; i++) {
			map.putIfAbsent(str[i], map.size());
		}

		for (int i = 0; i < num; i++) {
			sb.append(
					map.get(clone[i])
			).append(' ');
		}
		System.out.println(sb);
	}
}