import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int num = Integer.parseInt(br.readLine());

		for (int i = 0; i < num; i++) {
			Stack<String> stack = new Stack<>();
			String str = br.readLine();
			String[] arr = str.split(" ");

			sb.append("Case #").append(i + 1).append(": ");
			if (arr.length > 1) {

				for (int j = arr.length - 1; j >= 0; j--) {
					stack.push(arr[j]);
					sb.append(stack.pop()).append(' ');
				}
				sb.append('\n');
			} else {
				sb.append(str).append('\n');
			}
		}

		System.out.println(sb);
	}
}