import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] split = br.readLine().split(" ");

		int stone = Integer.parseInt(split[0]);
		int active = Integer.parseInt(split[1]);

		PriorityQueue<Long> pq = new PriorityQueue<>();

		long sum = 0;
		split = br.readLine().split(" ");

		for (int i = 0; i < stone; i++) {
			pq.offer(Long.parseLong(split[i]));
		}

		// 경험치가 (1) 200 + 300 (2)300 해서 800 임.
		// stone 만큼 반복하는데, active 갯수만큼 누적?
		// poll (x) -> poll (+) -> poll * 2 (+) -> poll * 3 (+)

		for (int i = 0; i < stone; i++) {
			if (i == 0) {
				pq.poll();
			} else {
				if (i > active) {
					sum += pq.poll() * active;
				} else {
					sum += pq.poll() * i;
				}
			}
		}

		System.out.println(sum);
	}
}