import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int num = Integer.parseInt(br.readLine());

		for (int i = 0; i < num; i++) {
			PriorityQueue<Long> pq = new PriorityQueue<>();
			int cycle = Integer.parseInt(br.readLine());
			String[] split = br.readLine().split(" ");

			for (int j = 0; j < cycle; j++) {
				pq.offer(Long.parseLong(split[j]));
			}

			long calculator = calculator(pq);

			sb.append(calculator).append('\n');
		}
		System.out.print(sb);
	}

	private static long calculator(PriorityQueue<Long> pq) {
		long count = 0;

		while (pq.size() > 1) {
			long sum = pq.poll() + pq.poll();
			count += sum;
			pq.offer(sum);
		}

		return count;
	}
}