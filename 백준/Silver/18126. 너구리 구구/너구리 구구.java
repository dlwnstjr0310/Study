import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

	static List<List<Edge>> list = new ArrayList<>();
	static int node, max;
	static boolean isEnd = false;
	static long answer;
	static boolean[] isChecked = new boolean[node + 1];

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		node = Integer.parseInt(br.readLine());
		isChecked = new boolean[node + 1];
		int edge = node - 1;

		for (int i = 0; i <= node; i++) {
			list.add(new ArrayList<>());
		}

		max = 0;
		for (int i = 0; i < edge; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int interval = Integer.parseInt(st.nextToken());

			max = Math.max(max, to);
			list.get(from).add(new Edge(from, to, interval));
			list.get(to).add(new Edge(to, from, interval));
		}

		dfs(1, 0);
		System.out.println(answer);
	}

	static void dfs(int idx, long interval) {
		isChecked[idx] = true;

		if (answer < interval) {
			answer = interval;
		}
		for (Edge edge : list.get(idx)) {
			if (!isChecked[edge.to]) {
				isChecked[edge.to] = true;
				dfs(edge.to, interval + edge.interval);
			}
		}
	}

	static class Edge {
		int from;
		int to;
		long interval;

		public Edge(int from, int to, long interval) {
			this.from = from;
			this.to = to;
			this.interval = interval;
		}
	}
}
