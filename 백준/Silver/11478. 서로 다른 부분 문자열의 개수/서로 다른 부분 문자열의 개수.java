import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		String str = br.readLine();

		Map<String, Integer> map = new HashMap<>();

		/*
		 * 한글자, 두글자, 세글자, 네글자, 다섯글자씩 잘라서 넣기
		 * */
		for (int i = 0; i <= str.length(); i++) {
			for (int j = 0; j <= str.length(); j++) {
				int max = Math.max(i, j);
				int min = Math.min(i, j);
				if (max != min) {
					map.put(str.substring(min, max), 0);
				}
			}
		}
		System.out.println(map.size());
	}
}