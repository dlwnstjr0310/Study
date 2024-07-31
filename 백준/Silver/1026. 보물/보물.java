import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int num = Integer.parseInt(br.readLine());

		/*
		 * 위 배열의 최소값 * 아래 배열의 최대값 : S 의 최소값
		 * */
		PriorityQueue<Integer> min = new PriorityQueue<>();
		PriorityQueue<Integer> max = new PriorityQueue<>((a, b) -> b - a);

		StringTokenizer st = new StringTokenizer(br.readLine());

		for (int i = 0; i < num; i++) {
			min.offer(Integer.parseInt(st.nextToken()));
		}

		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < num; i++) {
			max.offer(Integer.parseInt(st.nextToken()));
		}

		int sum = 0;

		for (int i = 0; i < num; i++) {
			sum += min.poll() * max.poll();
		}

		System.out.print(sum);
	}
}