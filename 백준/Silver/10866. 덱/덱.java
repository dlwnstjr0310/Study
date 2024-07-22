import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int num = Integer.parseInt(br.readLine());
		int target = 0;
		Deque<Integer> deque = new ArrayDeque<>();

		for (int i = 0; i < num; i++) {
			String str = br.readLine();

			if (str.startsWith("push")) {
				StringTokenizer st = new StringTokenizer(str);

				str = st.nextToken();
				target = Integer.parseInt(st.nextToken());
			}

			switch (str) {
				case "push_front":
					deque.addFirst(target);
					break;
				case "push_back":
					deque.addLast(target);
					break;
				case "pop_front":
					Integer first = deque.pollFirst();
					sb.append(
							first != null ? first : -1
					).append('\n');
					break;
				case "pop_back":
					Integer last = deque.pollLast();
					sb.append(
							last != null ? last : -1
					).append('\n');
					break;
				case "size":
					sb.append(deque.size())
							.append('\n');
					break;
				case "empty":
					sb.append(deque.isEmpty() ? 1 : 0)
							.append('\n');
					break;
				case "front":
					Integer firstNum = deque.peekFirst();
					sb.append(firstNum != null ? firstNum : -1)
							.append('\n');
					break;
				case "back":
					Integer lastNum = deque.peekLast();
					sb.append(lastNum != null ? lastNum : -1)
							.append('\n');
					break;
			}
		}

		System.out.print(sb);

	}
}