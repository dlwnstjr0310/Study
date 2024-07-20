import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String str = br.readLine().toUpperCase();

		Map<Character, Integer> map = new HashMap<>();

		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			map.put(c, map.getOrDefault(c, 0) + 1);
		}

		Integer max = map.values().stream().max(Integer::compareTo).orElse(0);

		Map<Character, Integer> secondMap = new HashMap<>();

		map.forEach((key, value) -> {
			if (value.equals(max)) {
				secondMap.put(key, value);
			}
		});

		if (secondMap.size() == 1) {
			System.out.println(secondMap.keySet().iterator().next());
		} else {
			System.out.println("?");
		}
	}
}