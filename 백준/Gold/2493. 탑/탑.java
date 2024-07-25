import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int number = Integer.parseInt(br.readLine());
		String[] arr = br.readLine().split(" ");
		Stack<int[]> stack = new Stack<>();

		/*
		 * 1. 탑 크기, 인덱스 만들기
		 * 2. 마지막 탑보다 작으면 맨 앞으로 빼고 몇번 뺐는지 기록하자
		 * 3. count == dq.size 면 0 기록, count < dq.size 일 때 찾으면 인덱스 기록
		 * 4. count 만큼 앞에서 뒤로 다시 보내면 되지않을까?
		 * 5. 여러번 바꿔봤는데 다 시간초과임
		 * 6. 진짜 열받아서 처음부터 다시시작
		 * 7. 첫번째는 무조건 0입력, 스택에 푸쉬
		 * 8. 2회차부터는 전값보다 크면 전값이 아무런 쓸모가 없지않나?
		 * 9. 작은값 작은값 큰값 은 무의미, 큰값 작은값 작은값은 유의미
		 * 10. 맞는듯. 그럼 전 값이 남아있지 않은경우 0 입력, 스택에 푸쉬
		 * 11. 69574 의 경우 957 남은상태에서 7의 인덱스가 저장되어야함
		 * 12. 여섯시간 걸림
		 * */

		for (int i = 1; i <= number; i++) {

			int height = Integer.parseInt(arr[i - 1]);

			while (!stack.isEmpty() && stack.peek()[0] < height) {
				stack.pop();
			}

			sb.append(stack.isEmpty() ? "0" : stack.peek()[1])
					.append(' ');

			stack.push(new int[]{height, i});
		}

		System.out.println(sb);

	}
}