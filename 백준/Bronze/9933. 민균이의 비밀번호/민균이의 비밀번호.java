import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int num = Integer.parseInt(br.readLine());
		Set<String> set = new HashSet<>();
		String[] arr = new String[num];
		String answer = "";

		for (int i = 0; i < num; i++) {
			String str = br.readLine();
			set.add(str);
			arr[i] = str;
		}

		for (int i = 0; i < arr.length; i++) {
			StringBuilder sb = new StringBuilder(arr[i]);
			String key = sb.reverse().toString();

			if (set.contains(key)) {
				answer = key.length() + " " + key.charAt((key.length() / 2));
			}
		}

		System.out.print(answer);
	}
}