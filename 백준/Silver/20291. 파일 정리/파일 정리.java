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
			String[] arr = br.readLine().split("\\.");

			map.put(arr[1], map.getOrDefault(arr[1], 0) + 1);
		}

		map.forEach((key, value) -> sb.append(key).append(' ').append(value).append('\n'));

		System.out.print(sb);
	}
}