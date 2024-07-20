import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int num = Integer.parseInt(br.readLine());

		Map<String, Integer> map = new HashMap<>();

		for (int i = 0; i < num; i++) {

			StringTokenizer st = new StringTokenizer(br.readLine());

			String fruit = st.nextToken();
			int number = Integer.parseInt(st.nextToken());

			map.put(fruit, map.getOrDefault(fruit, 0) + number);

//			map.compute(fruit, (key, value) -> {
//				if (value == null) {
//					return number;
//				} else if (value + number == 5) {
//					return value + number;
//				}
//				return number;
//			});
		}
		System.out.println(map.containsValue(5) ? "YES" : "NO");
	}

	private static int[] readLine(BufferedReader br) throws IOException {
		return Arrays.stream(br.readLine().split(" "))
				.mapToInt(Integer::parseInt)
				.toArray();
	}
}