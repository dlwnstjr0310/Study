import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

//		StringBuilder answer = new StringBuilder();

		String str = sc.nextLine().toUpperCase();

		Map<Character, Integer> map = new HashMap<>();

		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			map.put(c, map.getOrDefault(c, 0) + 1);
		}

		Integer i = map.values().stream().max(Integer::compareTo).orElse(0);

		Map<Character, Integer> second = new HashMap<>();

		map.forEach((key, value) -> {
			if (value.equals(i)) {
				second.put(key, value);
			}
		});

		if (second.size() == 1) {
			System.out.println(second.keySet().iterator().next());
		} else {
			System.out.println("?");
		}
	}
}