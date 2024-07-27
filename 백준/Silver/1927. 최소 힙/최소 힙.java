import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int num = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> pq = new PriorityQueue<>();

		for (int i = 0; i < num; i++) {
			int order = Integer.parseInt(br.readLine());

			if (order == 0 && pq.isEmpty()) {
				sb.append('0').append('\n');
			} else if (order == 0) {
				sb.append(pq.poll()).append('\n');
			} else {
				pq.offer(order);
			}
		}

		System.out.print(sb);
	}
}