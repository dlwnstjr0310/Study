import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		String[] arr = br.readLine().split(" ");
		int record = Integer.parseInt(arr[0]);
		int count = Integer.parseInt(arr[1]);

		Map<String, String> map = new HashMap<>();

		for (int i = 0; i < record; i++) {
			String[] target = br.readLine().split(" ");
			String key = target[2] + " " + target[3] + " " + target[4];

			map.compute(key, (k, value) -> {
				if (value != null) {
					return "?";
				} else {
					return target[1];
				}
			});
		}

		for (int i = 0; i < count; i++) {
			String target = br.readLine();

			sb.append(
					map.getOrDefault(target, "!")
			).append('\n');
		}

		System.out.print(sb);
	}
}