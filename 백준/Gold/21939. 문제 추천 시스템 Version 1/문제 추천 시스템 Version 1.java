import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int num = Integer.parseInt(br.readLine());

		PriorityQueue<Integer[]> hardQ = new PriorityQueue<>((a, b) ->
				b[1] != a[1] ? b[1] - a[1] : b[0] - a[0]
		);
		PriorityQueue<Integer[]> easyQ = new PriorityQueue<>((a, b) ->
				a[1] != b[1] ? a[1] - b[1] : a[0] - b[0]
		);
		Map<Integer, Integer> map = new HashMap<>();

		for (int i = 0; i < num; i++) {
			String[] arr = br.readLine().split(" ");

			int qNumber = Integer.parseInt(arr[0]);
			int dificPoint = Integer.parseInt(arr[1]);

			map.put(qNumber, dificPoint);
			hardQ.offer(new Integer[]{qNumber, dificPoint});
			easyQ.offer(new Integer[]{qNumber, dificPoint});
		}

		num = Integer.parseInt(br.readLine());

		for (int i = 0; i < num; i++) {
			String[] arr = br.readLine().split(" ");

			if (arr[0].equals("recommend")) {

				if (arr[1].equals("1")) {
					if (map.containsKey(hardQ.peek()[0])) {
						sb.append(hardQ.peek()[0]).append('\n');
					}
				} else {
					if (map.containsKey(easyQ.peek()[0])) {
						sb.append(easyQ.peek()[0]).append('\n');
					}
				}

			} else if (arr[0].equals("solved")) {
				int target = Integer.parseInt(arr[1]);

				map.remove(target);

				if (hardQ.peek()[0] == target) {
					hardQ.poll();
				}
				if (easyQ.peek()[0] == target) {
					easyQ.poll();
				}
			} else {
				map.put(Integer.parseInt(arr[1]), Integer.parseInt(arr[2]));
				hardQ.offer(new Integer[]{Integer.parseInt(arr[1]), Integer.parseInt(arr[2])});
				easyQ.offer(new Integer[]{Integer.parseInt(arr[1]), Integer.parseInt(arr[2])});
			}
		}

		System.out.print(sb);
	}
}