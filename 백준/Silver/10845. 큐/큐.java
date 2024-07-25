import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int num = Integer.parseInt(br.readLine());
		Queue<Integer> queue = new LinkedList<>();
		int target = 0;

		for (int i = 0; i < num; i++) {

			StringTokenizer st = new StringTokenizer(br.readLine());
			String str = st.nextToken();

			switch (str) {
				case "push":
					target = Integer.parseInt(st.nextToken());
					queue.add(target);
					break;
				case "pop":
					if (queue.isEmpty()) {
						sb.append(-1)
								.append('\n');
					} else {
						sb.append(queue.poll())
								.append('\n');
					}
					break;
				case "size":
					sb.append(queue.size())
							.append('\n');
					break;
				case "empty":
					if (queue.isEmpty()) {
						sb.append(1)
								.append('\n');
					} else {
						sb.append(0)
								.append('\n');
					}
					break;
				case "front":
					if (queue.isEmpty()) {
						sb.append(-1)
								.append('\n');
					} else {
						sb.append(queue.peek())
								.append('\n');
					}
					break;
				case "back":
					if (queue.isEmpty()) {
						sb.append(-1)
								.append('\n');
					} else {
						sb.append(target)
								.append('\n');
					}
					break;
			}
		}

		System.out.print(sb);
	}
}