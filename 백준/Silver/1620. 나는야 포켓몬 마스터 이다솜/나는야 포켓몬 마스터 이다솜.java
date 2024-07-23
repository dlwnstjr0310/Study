import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());

		Map<String, Integer> pokemonMap = new HashMap<>();
		Map<Integer, String> subMap = new HashMap<>();

		int length = Integer.parseInt(st.nextToken());
		int quiz = Integer.parseInt(st.nextToken());
		for (int i = 0; i < length; i++) {
			String str = br.readLine();
			pokemonMap.put(str, i + 1);
			subMap.put(i + 1, str);
		}

		for (int i = 0; i < quiz; i++) {
			String str = br.readLine();
			try {
				sb.append(subMap.get(Integer.parseInt(str)));
			} catch (NumberFormatException e) {
				sb.append(pokemonMap.get(str));
			}
			sb.append('\n');
		}
		System.out.print(sb);
	}
}