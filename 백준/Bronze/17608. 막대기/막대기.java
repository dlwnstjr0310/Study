import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int num = Integer.parseInt(br.readLine());
		Stack<Integer> stack = new Stack<>();
		int count = 1;

		for (int i = 0; i < num; i++) {
			stack.push(Integer.parseInt(br.readLine()));
		}

		Integer height = stack.pop();

		while (!stack.isEmpty()) {
			Integer currentHeight = stack.pop();

			if (height < currentHeight) {
				height = currentHeight;
				count++;
			}
		}

		System.out.println(count);
	}
}