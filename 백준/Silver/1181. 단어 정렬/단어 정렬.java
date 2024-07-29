import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.TreeSet;

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int num = Integer.parseInt(br.readLine());
		Set<String> set = new TreeSet<>((a, b) -> {
			if (a.length() != b.length()) {
				return a.length() - b.length();
			} else {
				return a.compareTo(b);
			}
		});

		for (int i = 0; i < num; i++) {
			set.add(br.readLine());
		}

		set.forEach(str -> sb.append(str).append('\n'));
		
		System.out.print(sb);
	}
}