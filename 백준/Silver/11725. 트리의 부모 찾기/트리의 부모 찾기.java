import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Main {

	static int N;
	static boolean[] isLeaf;
	static List<List<Integer>> list = new ArrayList<>();
	static int[] answer;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(br.readLine());
		answer = new int[N + 1];
		isLeaf = new boolean[N + 1];

		for (int i = 0; i <= N; i++) {
			list.add(new ArrayList<>());
		}

		for (int i = 0; i < N - 1; i++) {
			String[] split = br.readLine().split(" ");

			int parents = Integer.parseInt(split[0]);
			int child = Integer.parseInt(split[1]);

			list.get(parents).add(child);
			list.get(child).add(parents);
		}

		bfs();

		for (int i = 2; i <= N; i++) {
			sb.append(answer[i]).append('\n');
		}

		System.out.print(sb);
	}

	static void bfs() {

		isLeaf[1] = true;

		Queue<Integer> q = new ArrayDeque<>();
		q.offer(1);

		while (!q.isEmpty()) {
			Integer poll = q.poll();
			List<Integer> nodes = list.get(poll);

			for (Integer node : nodes) {

				if (!isLeaf[node]) {
					isLeaf[node] = true;
					answer[node] = poll;
					q.offer(node);
				}
			}
		}
	}
}