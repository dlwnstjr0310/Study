import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		String str = br.readLine();

		Stack<String> stack = new Stack<>();
		Stack<String> subStack = new Stack<>();

		for (int i = 0; i < str.length(); i++) {
			stack.push(String.valueOf(str.charAt(i)));
		}

		int num = Integer.parseInt(br.readLine());

		for (int i = 0; i < num; i++) {

			StringTokenizer st = new StringTokenizer(br.readLine());
			/*
			 * 1. List 사용해서 구현, 시간초과
			 * 2. 스택을 사용해보기로 함
			 * 3. 커서를 왼쪽으로 움직일 때, 메인 스택에서 한글자씩 서브스택으로 이동
			 * 4. 커서를 오른쪽으로 움직이면 서브스택에서 한글자씩 메인 스택으로 이동
			 * 5. 추가/삭제 시 현재 커서의 위치인 메인 스택에서 진행
			 * 6. 종료 후 메인 스택은 정방향 출력, 서브 스택은 역방향 출력
			 * */

			switch (st.nextToken()) {
				case "L":
					if (!stack.isEmpty()) {
						subStack.push(stack.pop());
					}
					break;
				case "D":
					if (!subStack.isEmpty()) {
						stack.push(subStack.pop());
					}
					break;
				case "B":
					if (!stack.isEmpty()) {
						stack.pop();
					}
					break;
				case "P":
					stack.push(st.nextToken());
					break;
			}
		}

		if (!stack.isEmpty()) {
			for (String s : stack) {
				sb.append(s);
			}
		}
		while (!subStack.isEmpty()) {
			sb.append(subStack.pop());
		}

		System.out.print(sb);
	}
}