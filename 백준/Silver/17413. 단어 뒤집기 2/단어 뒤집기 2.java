import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringBuilder answer = new StringBuilder();
		String str = br.readLine();

		Stack<Character> stack = new Stack<>();
		boolean isTag = false;

		for (int i = 0; i < str.length(); i++) {

			char c = str.charAt(i);

			if (isTag) {
				answer.append(c);
				if (c == '>') {
					isTag = false;
				}
			} else if (c == '<') {
				pop(stack, answer);
				answer.append(c);
				isTag = true;
			} else {
				if (i == str.length() - 1 && !stack.empty()) {
					stack.push(c);
					pop(stack, answer);
				} else if (c == ' ') {
					pop(stack, answer);
					answer.append(c);
				} else {
					stack.push(c);
				}
			}
		}

		System.out.println(answer);
	}

	private static void pop(Stack<Character> stack, StringBuilder answer) {
		while (!stack.empty()) {
			answer.append(stack.pop());
		}
	}
}