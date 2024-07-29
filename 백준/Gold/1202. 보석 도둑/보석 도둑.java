import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		String[] split = br.readLine().split(" ");
		int jewelCount = Integer.parseInt(split[0]);
		int bagCount = Integer.parseInt(split[1]);

		PriorityQueue<Integer> bagList = new PriorityQueue<>();
		PriorityQueue<Integer> min = new PriorityQueue<>((a, b) -> b - a);
		PriorityQueue<int[]> max = new PriorityQueue<>((a, b) -> {
			if (a[0] == b[0]) {
				return b[1] - a[1];
			}
			return a[0] - b[0];
		});

		for (int i = 0; i < jewelCount; i++) {
			st = new StringTokenizer(br.readLine());
			max.offer(new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())});
		}

		for (int i = 0; i < bagCount; i++) {
			bagList.offer(Integer.parseInt(br.readLine()));
		}

		long answer = 0;

		for (int i = 0; i < bagCount; i++) {

			if (!bagList.isEmpty()) {
				int bag = bagList.poll();

				while (!max.isEmpty() && bag >= max.peek()[0]) {
					min.offer(max.poll()[1]);
				}
			}

			if (!min.isEmpty()) {
				answer += min.poll();
			}
		}

		System.out.println(answer);
	}
}