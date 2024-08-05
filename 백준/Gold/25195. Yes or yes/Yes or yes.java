import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

	static List<List<Node>> list = new ArrayList<>();
	static Set<Integer> fans = new HashSet<>();

	public static void main(String[] args) throws IOException {

		/*
		 * 1. 입력 : 첫 줄에 정점의 개수 N , 간선의 개수 M 이 주어지고, 이후 M 개의 줄에 간선의 정보가 주어짐.
		 *          이후 M+2 번째 줄부터 팬클럽이 존재하는 정점의 개수 S, 다음줄엔 정점의 번호 s 가 주어진다!
		 *
		 * 2. 기능 : 곰곰이가 간선을 따라 이동하면서 팬클럽 곰곰이를 안만날 수 있는지 구하기
		 * 2-1 : 출발지와 도착지 저장하기
		 * 2-2 : start 에서 출발해서 to 로 계속 이동하는데, withFan 을 안만나고 완주하면 yes, withFan 을 만나면 Yes
		 * -> withFan 이 false 인 to 로 이동했을 때 더이상 이동할곳이 없으면 yes
		 *
		 * 3. 출력 : 팬클럽을 만나면 Yes, 아니라면 yes 출력
		 * */

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] split = br.readLine().split(" ");
		int N = Integer.parseInt(split[0]);
		int M = Integer.parseInt(split[1]);

		String[] arr = new String[M];

		for (int i = 0; i < M; i++) {
			arr[i] = br.readLine();
		}

		int fanCount = Integer.parseInt(br.readLine());

		split = br.readLine().split(" ");

		for (int i = 0; i < fanCount; i++) {
			int target = Integer.parseInt(split[i]) - 1;
			fans.add(target);
			if (target == 0) {
				System.out.println("Yes");
				System.exit(0);
			}
		}

		for (int i = 0; i < N; i++) {
			list.add(new ArrayList<>());
		}

		for (int i = 0; i < M; i++) {
			String[] str = arr[i].split(" ");

			int from = Integer.parseInt(str[0]) - 1;
			int to = Integer.parseInt(str[1]) - 1;

			if (fans.contains(from) || fans.contains(to)) {
				list.get(from).add(new Node(from, to, true));
			} else {
				list.get(from).add(new Node(from, to));
			}

		}

		bfs(0);
		System.out.println("Yes");
	}

	static void bfs(int start) {

		Queue<Integer> q = new ArrayDeque<>();
		q.offer(start);
		while (!q.isEmpty()) {
			List<Node> nodes = list.get(q.poll());

			if (nodes.isEmpty()) {
				System.out.println("yes");
				System.exit(0);
			}
			for (Node node : nodes) {
				if (!node.withFan) {
					q.offer(node.to);
				}
			}
		}


	}

	static class Node {
		int from;
		int to;
		boolean withFan;

		public Node(int from, int to) {
			this.from = from;
			this.to = to;
		}

		public Node(int from, int to, boolean withFan) {
			this.from = from;
			this.to = to;
			this.withFan = withFan;
		}

	}
}
