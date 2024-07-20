import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int num = Integer.parseInt(br.readLine());

		Set<String> set = new HashSet<>();
		int answer = 0;

		for (int i = 0; i < num; i++) {
			String str = br.readLine();

			if (str.equals("ENTER")) {
				answer += set.size();
				set.clear();
			} else {
				set.add(str);
			}
		}
		
		answer += set.size();

		System.out.println(answer);
	}
}