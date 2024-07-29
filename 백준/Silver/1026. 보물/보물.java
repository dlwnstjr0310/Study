import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int num = Integer.parseInt(br.readLine());
		String[] arr1 = br.readLine().split(" ");
		String[] arr2 = br.readLine().split(" ");

		PriorityQueue<Integer> min = new PriorityQueue<>();
		PriorityQueue<Integer> max = new PriorityQueue<>((a, b) -> b - a);

		for (int i = 0; i < num; i++) {
			min.offer(Integer.parseInt(arr1[i]));
			max.offer(Integer.parseInt(arr2[i]));
		}

		int sum = 0;

		for (int i = 0; i < num; i++) {
			sum += min.poll() * max.poll();
		}
		
		System.out.println(sum);
	}
}