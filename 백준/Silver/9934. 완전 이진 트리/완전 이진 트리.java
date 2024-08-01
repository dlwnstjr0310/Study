import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

	static StringBuilder sb = new StringBuilder();
	static List<Integer> list = new ArrayList<>();

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder answer = new StringBuilder();

		int num = Integer.parseInt(br.readLine());

		for (String s : br.readLine().split(" ")) {
			list.add(Integer.parseInt(s));
		}

		for (int i = num - 1; i >= 0; i--) {
			split();
		}

		String[] split = sb.toString().split("\n");

		for (int i = split.length - 1; i >= 0; i--) {
			answer.append(split[i]).append('\n');
		}

		System.out.print(answer);
	}

	static void split() {

		List<Integer> deleteList = new ArrayList<>();

		for (int i = 0; i < list.size(); i += 2) {
			sb.append(list.get(i)).append(' ');
			deleteList.add(list.get(i));
		}

		for (Integer target : deleteList) {
			list.remove(target);
		}
		sb.append('\n');
	}
}