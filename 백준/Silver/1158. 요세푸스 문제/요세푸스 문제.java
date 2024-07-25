import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		String[] arr = br.readLine().split(" ");

		Queue<Integer> queue = new ArrayDeque<>();

		int people = Integer.parseInt(arr[0]);
		int delete = Integer.parseInt(arr[1]);

		for (int i = 1; i <= people; i++) {
			queue.add(i);
		}

		/*
		 * 1. list 순회하면서 0 이 아닐때마다 카운트 하나씩 올리기
		 * 2. 카운트가 arr[1] 과 같아지면 해당 인덱스 0으로 교체하고 저장
		 * 3. 반복
		 * 4. 나는 왜이렇게 시간이 오래걸리지
		 * 5. 0으로 교체 없이 빼서 sb 에 넣으면 될듯
		 * */

		sb.append('<');

		while (queue.size() > 1) {

			for (int i = 0; i < delete - 1; i++) {
				queue.add(queue.poll());
			}

			sb.append(queue.poll())
					.append(',')
					.append(' ');
		}

		sb.append(queue.poll())
				.append('>');

		System.out.print(sb);
	}
}