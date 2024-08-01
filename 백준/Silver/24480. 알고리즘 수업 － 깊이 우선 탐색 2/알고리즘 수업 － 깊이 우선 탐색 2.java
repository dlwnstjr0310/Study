import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

	static int[] answer;
	static int count = 1;
	static List<List<Integer>> list = new ArrayList<>();

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int[] num = Arrays.stream(br.readLine().split(" "))
				.mapToInt(Integer::parseInt)
				.toArray();

		int vertex = num[0];
		int edge = num[1];
		int startPoint = num[2];

		answer = new int[vertex + 1];

		for (int i = 0; i < vertex + 1; i++) {
			list.add(new ArrayList<>());
		}

		for (int i = 0; i < edge; i++) {
			String[] arr = br.readLine().split(" ");
			int u = Integer.parseInt(arr[0]);
			int v = Integer.parseInt(arr[1]);

			list.get(u).add(v);
			list.get(v).add(u);
		}

		dfs(startPoint);

		for (int i = 1; i < answer.length; i++) {
			sb.append(answer[i]).append('\n');
		}

		System.out.print(sb);
	}

	static void dfs(int start) {

		answer[start] = count;
		List<Integer> nodes = list.get(start);
		nodes.sort((a, b) -> b - a);

		for (int i = 0; i < nodes.size(); i++) {
			Integer node = nodes.get(i);
			if (answer[node] == 0) {
				count++;
				dfs(node);
			}
		}
	}
}