import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
		String[] arr = br.readLine().split(" ");

		int giantCount = Integer.parseInt(arr[0]);
		int centiHeight = Integer.parseInt(arr[1]);
		int breakCount = Integer.parseInt(arr[2]);

		for (int i = 0; i < giantCount; i++) {
			maxHeap.offer(Integer.parseInt(br.readLine()));
		}

		while (!maxHeap.isEmpty() && breakCount > 0) {

			Integer giantHeight = maxHeap.poll();

			if (giantHeight == 1 || giantHeight < centiHeight) {
				maxHeap.offer(giantHeight);
				break;
			} else {
				giantHeight /= 2;
				breakCount--;
				maxHeap.offer(giantHeight);
			}
		}

		String answer = centiHeight > maxHeap.peek() ? "YES" : "NO";
		sb.append(answer).append('\n');
		sb.append(answer.equals("YES") ? Integer.parseInt(arr[2]) - breakCount : maxHeap.peek());

		System.out.print(sb);
	}
}