import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int num = Integer.parseInt(br.readLine());

		if (num != 1) {

			PriorityQueue<Integer> left = new PriorityQueue<>();

			for (int i = 0; i < num; i++) {
				int target = Integer.parseInt(br.readLine());

				left.offer(target);
			}

			long leftCal = calculator(left);
			System.out.println(leftCal);
		} else {
			System.out.println(0);
		}

	}

	private static long calculator(PriorityQueue<Integer> pq) {
		long count = 0;

		while (pq.size() > 1) {
			long sum = pq.poll() + pq.poll();
			count += sum;
			pq.offer((int) sum);
		}

		return count;
	}
}