import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int num = Integer.parseInt(br.readLine());

		Map<String, String> map = new HashMap<>();
		for (int i = 0; i < num; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String key = st.nextToken();
			String value = st.nextToken();

			map.compute(key, (k, v) -> value.equals("leave") ? null : value);
		}

		// 역순 출력
		List<String> list = map.keySet().stream()
				.sorted(Comparator.reverseOrder())
				.collect(Collectors.toList());

		for (String s : list) {
			sb.append(s).append('\n');
		}

		System.out.println(sb);
	}
}