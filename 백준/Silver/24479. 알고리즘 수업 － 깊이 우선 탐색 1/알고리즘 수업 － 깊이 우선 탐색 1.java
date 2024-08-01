import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
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

		answer = new int[num[0] + 1];

		for (int i = 0; i < num[0] + 1; i++) {
			list.add(new ArrayList<>());
		}

		/*
		 * 1. 의사 코드를 보니까.. 1 2 3 4 5 를 넣어두고 재귀호출 하는 방식인듯
		 * 2. 도저히 이해가 안되서 구글링
		 * 3. 답으로 사용할 배열이 하나 더 필요한거였음.
		 * -> int[] answer 을 만들어두고, 오름차순 정렬하면
		 * i = 1 일때 answer[1] = 1 -> nodes = {2, 4} -> node = 2 -> answer[2] == 0 -> count++ 후 dfs(2) 호출
		 * 이후 i = 2 니까, answer[2] = 2 -> nodes = {1,3,4} -> answer[1] != 0 이니까 3 호출
		 * */
		for (int i = 0; i < num[1]; i++) {  // 1 -> 2 니까 간선 정보임
			String[] arr = br.readLine().split(" ");
			int u = Integer.parseInt(arr[0]);
			int v = Integer.parseInt(arr[1]);

			// 양방향 간선 => 양쪽에 입력
			list.get(u).add(v);
			list.get(v).add(u);
		}

		dfs(num[2]);

		for (int i = 1; i < answer.length; i++) {
			sb.append(answer[i]).append('\n');
		}
		System.out.print(sb);

	}

	static void dfs(int i) {

		List<Integer> nodes = list.get(i);
		nodes.sort((a,b) -> a-b);
		answer[i] = count;

		for (int j = 0; j < nodes.size(); j++) {
			Integer node = nodes.get(j);
			if (answer[node] == 0) {
				count++;
				dfs(node);
			}
		}
	}
}