import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
		StringBuilder sb = new StringBuilder();

		int num = Integer.parseInt(br.readLine());


		for (int i = 0; i < num; i++) {

			String[] arr = br.readLine().split(" ");

			for (int j = 0; j < num; j++) {

				maxHeap.offer(Integer.parseInt(arr[j]));

			}

		}

		for (int i = 0; i < num; i++) {
			Integer poll = maxHeap.poll();
			if (i == num - 1) {
				sb.append(poll);
			}
		}
		System.out.println(sb);
	}
}