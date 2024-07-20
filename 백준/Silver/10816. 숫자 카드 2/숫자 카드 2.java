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

		Map<Integer, Integer> map = new HashMap<>();
		StringTokenizer st = new StringTokenizer(br.readLine());

		for (int i = 0; i < num; i++) {
//			set.add(Integer.parseInt(st.nextToken()));
			int cardNumber = Integer.parseInt(st.nextToken());

			map.compute(cardNumber, (key, value) -> {
				if (value == null) {
					return 1;
				} else {
					return value + 1;
				}
			});
		}

		int target = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < target; i++) {
			int cardNumber = Integer.parseInt(st.nextToken());
			sb.append(
					map.getOrDefault(cardNumber, 0)
			).append(' ');
		}

		System.out.println(sb);
	}
}