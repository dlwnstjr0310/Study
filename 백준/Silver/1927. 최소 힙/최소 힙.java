import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int num = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> minHeap = new PriorityQueue<>();

		for (int i = 0; i < num; i++) {
			int order = Integer.parseInt(br.readLine());

			if (minHeap.isEmpty() && order == 0) {
				sb.append(0).append('\n');
			} else if (order == 0) {
				sb.append(minHeap.poll()).append('\n');
			} else {
				minHeap.offer(order);
			}
		}

		System.out.println(sb);
	}
}