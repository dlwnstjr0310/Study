import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int balloonCount = Integer.parseInt(br.readLine());
		String[] arr = br.readLine().split(" ");

		Deque<Integer[]> deque = new ArrayDeque<>();

		for (int i = 0; i < balloonCount; i++) {
			deque.add(new Integer[]{Integer.parseInt(arr[i]), i + 1});
		}

		sb.append(1)
				.append(' ');

		int target = deque.removeFirst()[0];

		while (!deque.isEmpty()) {

			if (target > 0) {
				for (int i = 1; i < target; i++) {
					deque.addLast(deque.removeFirst());
				}
			} else {
				for (int i = 0; i > target; i--) {
					deque.addFirst(deque.removeLast());
				}
			}

			Integer[] currentBallon = deque.pop();

			target = currentBallon[0];
			sb.append(currentBallon[1])
					.append(' ');
		}

		System.out.println(sb);
	}
}