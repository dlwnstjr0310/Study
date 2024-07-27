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

		/* 조합에서 종류가 n 개면 (n1+1) * (n2+1) * (n3+1) 이 조합의 수 */

		for (int i = 0; i < count; i++) {

			Map<String, Integer> map = new HashMap<>();
			int costumeCount = Integer.parseInt(br.readLine());

			for (int j = 0; j < costumeCount; j++) {
				String[] arr = br.readLine().split(" ");
				map.put(arr[1], map.getOrDefault(arr[1], 0) + 1);
			}

			if (map.size() > 1) {
				int sum = 1;

				for (int value : map.values()) {
					sum *= value + 1;
				}

				sb.append(sum - 1).append('\n');
			} else {
				if (map.size() == 1) {
					int value = 0;

					for (Integer val : map.values()) {
						value = val;
					}
					
					sb.append(value);
				} else {
					sb.append(0);
				}
				sb.append('\n');
			}
		}
		System.out.print(sb);
	}
}
