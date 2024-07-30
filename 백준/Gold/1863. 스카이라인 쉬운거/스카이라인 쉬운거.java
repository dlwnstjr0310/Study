import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int num = Integer.parseInt(br.readLine());

		int cnt = 0;
		Stack<Integer> stack = new Stack<>();

		for (int i = 0; i < num; i++) {
			String[] split = br.readLine().split(" ");
			int item = Integer.parseInt(split[1]);

			if (item == 0) {
				if (!stack.isEmpty()) {
					cnt += stack.size();
					stack.clear();
				}
				continue;
			}
			if (stack.isEmpty()) {
				stack.push(item);
			} else {
				if (stack.peek() > item) {
					while (!stack.isEmpty() && stack.peek() > item) {
						stack.pop();
						cnt++;
					}
					if (stack.isEmpty() || stack.peek() < item) {
						stack.push(item);
					}
				} else {
					stack.push(item);
				}
			}
		}

		if (!stack.isEmpty()) {
			System.out.print(cnt + stack.size());
		} else {
			System.out.print(cnt);
		}
	}
}