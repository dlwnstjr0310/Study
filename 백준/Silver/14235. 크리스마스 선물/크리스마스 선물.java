import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);

		int count = Integer.parseInt(br.readLine());
        
		for (int i = 0; i < count; i++) {
			String[] arr = br.readLine().split(" ");
			int point = Integer.parseInt(arr[0]);

			if (point == 0 && maxHeap.isEmpty()) {
				sb.append(-1).append('\n');
			} else if (point == 0) {
				sb.append(maxHeap.poll()).append('\n');
			} else {
				for (int j = 1; j < arr.length; j++) {
					maxHeap.offer(Integer.parseInt(arr[j]));
				}
			}
		}

		System.out.println(sb);
	}
}