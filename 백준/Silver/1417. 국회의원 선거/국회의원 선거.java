import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> b[1] - a[1]);
		int num = Integer.parseInt(br.readLine());
		int[] dasom = new int[2];

		for (int i = 0; i < num; i++) {
			if (i == 0) {
				dasom = new int[]{i + 1, Integer.parseInt(br.readLine())};
			} else {
				maxHeap.offer(new int[]{i + 1, Integer.parseInt(br.readLine())});
			}
		}

		/*
		 * 1. 다솜이는 따로 저장
		 * 2. 나머지 후보는 우선순위 큐에 담기
		 * 3. 가장 큰 후보의 표를 하나 빼 다솜이에게 주고 카운트 +1
		 * 4. 큐의 루트보다 다솜이의 표가 더 커졌을때 출력
		 * */
		int count = 0;
		while (!maxHeap.isEmpty() && dasom[1] <= maxHeap.peek()[1]) {

			int[] target = maxHeap.poll();
			target[1] -= 1;
			dasom[1] += 1;
			count++;
			maxHeap.offer(target);

		}

		System.out.println(count);
	}
}