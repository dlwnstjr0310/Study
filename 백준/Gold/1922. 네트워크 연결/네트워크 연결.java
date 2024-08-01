import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static int[] parent;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int comCount = Integer.parseInt(br.readLine());
		int lineCount = Integer.parseInt(br.readLine());

		List<Edge> edges = new ArrayList<>();

		/*
		 * 최소 신장 트리 ( Minimum Spanning Tree )
		 * 신장트리 : 그래프의 모든 정점이 연결된 사이클이 없는 그래프
		 * 최소 신장트리 : 신장트리 중 간선의 가중치 합이 가장 적은 그래프
		 * 노드 : from, to / 가중치 : cost
		 * */
		for (int i = 0; i < lineCount; i++) {

			StringTokenizer st = new StringTokenizer(br.readLine());

			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());

			edges.add(new Edge(from - 1, to - 1, cost));
		}

		// 가중치 기준 오름차순 정렬
		edges.sort(Comparator.comparingInt(a -> a.weight));

		// 자기 자신을 최상위 노드로 설정
		parent = new int[comCount];
		for (int i = 0; i < comCount; i++) {
			parent[i] = i;
		}

		int mstWeight = 0;
		for (Edge edge : edges) {
			// 최상위 노드 탐색
			int x = find(edge.from);
			int y = find(edge.to);

			// 최상위 노드가 같지않으면 사이클이 존재하지 않는다고 판단
			if (x != y) {
				// y의 루트노드를 x 로 설정
				union(x, y);
				mstWeight += edge.weight;
			}
		}

		System.out.print(mstWeight);
	}

	static int find(int i) {
		if (parent[i] == i) {
			return i;
		} else {
			parent[i] = find(parent[i]);
			return parent[i];
		}
	}

	static void union(int x, int y) {
		int rootX = find(x);
		int rootY = find(y);
		if (rootX != rootY) {
			parent[rootY] = rootX;
		}
	}


}

class Edge {
	int from, to, weight;

	Edge(int from, int to, int weight) {
		this.from = from;
		this.to = to;
		this.weight = weight;
	}
}