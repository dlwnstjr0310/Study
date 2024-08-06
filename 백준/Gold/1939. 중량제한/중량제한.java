import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

	static List<List<Island>> adjList = new ArrayList<>();
	static boolean[] isVisited;
	static int islandCount;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		islandCount = Integer.parseInt(st.nextToken());
		int bridgeInfo = Integer.parseInt(st.nextToken());

		/*
		 * 마지막 라인이 출발지 -> 도착지
		 * 여기저기 들리면서 제일 많이 가지고갈 수 있는거
		 *
		 * 반례
		 * 5 6
		 * 1 2 7
		 * 2 3 3
		 * 2 4 5
		 * 4 5 1
		 * 4 3 6
		 * 5 1 3
		 * 1 3
		 * */
		for (int i = 0; i <= islandCount; i++) {
			adjList.add(new ArrayList<>());
		}

		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;

		for (int i = 0; i < bridgeInfo; i++) {
			st = new StringTokenizer(br.readLine());

			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());

			adjList.get(from).add(new Island(to, weight));
			adjList.get(to).add(new Island(from, weight));

			max = Math.max(max, weight);
			min = Math.min(min, weight);
		}

		st = new StringTokenizer(br.readLine());

		int from = Integer.parseInt(st.nextToken());
		int to = Integer.parseInt(st.nextToken());

		int answer = 0;

		while (min <= max) {
			// 이분탐색
			int mid = (min + max) / 2;

			if (bfs(from, to, mid)) {
				min = mid + 1;
				answer = mid;
			} else {
				max = mid - 1;
			}
		}

		System.out.println(answer);
	}

	public static boolean bfs(int from, int to, int weight) {

		Queue<Island> q = new ArrayDeque<>();
		q.add(new Island(from, 0));
		isVisited = new boolean[islandCount + 1];
		isVisited[from] = true;

		while (!q.isEmpty()) {
			Island curr = q.poll();

			if (curr.to == to) {
				return true;
			}

			for (Island nextTarget : adjList.get(curr.to)) {

				if (weight <= nextTarget.weight && !isVisited[nextTarget.to]) {
					isVisited[nextTarget.to] = true;
					q.add(nextTarget);
				}
			}
		}
		return false;
	}

	public static class Island {
		int to;
		int weight;

		Island(int to, int weight) {
			this.to = to;
			this.weight = weight;
		}
	}
}