import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int count = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
		PriorityQueue<Integer> minHeap = new PriorityQueue<>();

		for (int i = 0; i < count; i++) {

			int target = Integer.parseInt(br.readLine());

			if (maxHeap.size() == minHeap.size()) {
				maxHeap.offer(target);
			} else {
				minHeap.offer(target);
			}

			if (!maxHeap.isEmpty() && !minHeap.isEmpty()) {

				if (maxHeap.peek() > minHeap.peek()) {
					Integer max = maxHeap.poll();
					Integer min = minHeap.poll();
					maxHeap.offer(min);
					minHeap.offer(max);
				}
			}
			
			sb.append(maxHeap.peek())
					.append('\n');
		}
		System.out.print(sb);
	}
}