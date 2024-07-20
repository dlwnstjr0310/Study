import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int num = Integer.parseInt(br.readLine());

		Map<String, Integer> map = new TreeMap<>(Comparator.naturalOrder());

		for (int i = 0; i < num; i++) {
			String str = br.readLine();

			map.compute(str, (key, value) -> {
				if (value == null) {
					return 1;
				} else {
					return value + 1;
				}
			});
		}

		Integer max = map.values().stream().max(Comparator.naturalOrder()).get();

		map.forEach((key, value) -> {
			if (value.equals(max) && sb.length() == 0) {
				sb.append(key);
			}
		});

		System.out.println(sb);
	}
}