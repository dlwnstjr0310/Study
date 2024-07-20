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

		String str = br.readLine();

		Set<String> set = new HashSet<>();

		/*
		 * 한글자, 두글자, 세글자, 네글자, 다섯글자씩 잘라서 넣기
		 * */
		for (int i = 0; i < str.length(); i++) {
			for (int j = i + 1; j <= str.length(); j++) {
				set.add(str.substring(i, j));
			}
		}
		System.out.println(set.size());
	}
}