import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String str = br.readLine();
		Set<String> set = new HashSet<>();

		for (int i = 0; i < str.length(); i++) {
			for (int j = i; j <= str.length(); j++) {
				String substring = str.substring(i, j);
				if (!substring.isBlank()) {
					set.add(substring);
				}
			}
		}

		System.out.println(set.size());
	}
}