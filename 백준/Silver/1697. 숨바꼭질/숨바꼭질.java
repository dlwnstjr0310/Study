import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {

	static boolean[] isVisited = new boolean[100001];

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] split = br.readLine().split(" ");

		int subin = Integer.parseInt(split[0]);
		int brother = Integer.parseInt(split[1]);

		if (subin == brother) {
			System.out.println(0);
		} else {
			bfs(subin, brother);
		}
	}

	private static void bfs(int subin, int brother) {

		Queue<Integer> q = new ArrayDeque<>();
		q.add(subin);
		int count = 0;

		while (true) {
			count++;
			int size = q.size();

			for (int i = 0; i < size; i++) {
				int x = q.remove();
				isVisited[x] = true;

				if (x - 1 == brother || x + 1 == brother || x * 2 == brother) {
					System.out.println(count);
					return;
				}
				if (x - 1 >= 0 && !isVisited[x - 1]) {
					isVisited[x - 1] = true;
					q.add(x - 1);
				}
				if (x + 1 <= 100000 && !isVisited[x + 1]) {
					isVisited[x + 1] = true;
					q.add(x + 1);
				}
				if (x * 2 <= 100000 && !isVisited[x * 2]) {
					isVisited[x * 2] = true;
					q.add(x * 2);
				}
			}
		}
	}
}