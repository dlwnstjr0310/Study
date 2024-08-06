import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

	static List<List<Integer>> list = new ArrayList<>();
	static boolean[] isVisited;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int num = Integer.parseInt(br.readLine());
		isVisited = new boolean[num + 1];

		for (int i = 0; i <= num; i++) {
			list.add(new ArrayList<>());
		}

		for (int i = 1; i < num; i++) {
			int target = Integer.parseInt(br.readLine());

			String[] split = br.readLine().split(" ");
			for (int j = 0; j < target; j++) {
				list.get(i).add(Integer.parseInt(split[j]));
			}
		}

		dfs(1);
		System.out.println("NO CYCLE");

	}

	static void dfs(int num) {

		if (isVisited[num]) {
			System.out.println("CYCLE");
			System.exit(0);
		}

		isVisited[num] = true;

		for (int i : list.get(num)) {
			dfs(i);
		}

		isVisited[num] = false;
	}
}