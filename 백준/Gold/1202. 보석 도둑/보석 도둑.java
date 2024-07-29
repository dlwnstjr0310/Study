import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] split = br.readLine().split(" ");
		int count = Integer.parseInt(split[0]);

		List<Integer> list = new ArrayList<>();
		int[][] max = new int[count][2];

		for (int i = 0; i < count; i++) {
			String[] arr = br.readLine().split(" ");
			max[i] = new int[]{Integer.parseInt(arr[0]), Integer.parseInt(arr[1])};
		}

		for (int i = 0; i < Integer.parseInt(split[1]); i++) {
			list.add(Integer.parseInt(br.readLine()));
		}

		long answer = 0;
		list.sort(Integer::compareTo);
		Arrays.sort(max, (a, b) -> {
			if (a[0] == b[0]) {
				return b[1] - a[1];
			}
			return a[0] - b[0];
		});

		PriorityQueue<Integer> min = new PriorityQueue<>((a, b) -> b - a);
		int index = 0;

		for (int i = 0; i < list.size(); i++) {

			while (index < max.length && max[index][0] <= list.get(i)) {
				min.offer(max[index][1]);
				index++;
			}

			if (!min.isEmpty()) {
				answer += min.poll();
			}
		}

		System.out.println(answer);
	}
}