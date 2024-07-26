import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int count = Integer.parseInt(br.readLine());

		for (int i = 0; i < count; i++) {

			Map<String, Integer> map = new HashMap<>();
			int clothCount = Integer.parseInt(br.readLine());

			for (int j = 0; j < clothCount; j++) {
				String[] arr = br.readLine().split(" ");

				map.put(arr[1], map.getOrDefault(arr[1], 0) + 1);
			}

			if (map.size() > 1) {
				int combinationCount = 1;
				for (Integer value : map.values()) {
					combinationCount *= (value + 1);
				}
				sb.append(combinationCount - 1).append('\n');
			} else {
				if (map.size() == 1) {
					int value = 0;
					for (Integer v : map.values()) {
						value = v;
					}
					sb.append(value).append('\n');
				} else {
					sb.append(0).append('\n');
				}
			}
		}

		System.out.print(sb);
	}
}