import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int count = Integer.parseInt(br.readLine());
		int answer = 0;
		Set<String> set = new HashSet<>();

		for (int i = 0; i < count; i++) {
			String str = br.readLine();

			if (!str.equals("ENTER")) {
				set.add(str);
			} else {
				answer += set.size();
				set.clear();
			}
		}

		System.out.println(answer + set.size());
	}
}