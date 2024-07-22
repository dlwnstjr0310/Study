import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int num = Integer.parseInt(br.readLine());
		int count = 0;

		/*
		 * 1. 연결된것 사이에 다른 연결이 있으면 X
		 * 2. 단어가 홀수면 X
		 * 되는것 : AABB,ABBA,AA,ABBABB, ABBBABAABABA : 12 34, 14 23, 12, 14 23 56 , 1-12 2-3 4-11 5-10 6-9 7-8
		 * 안되는것 : ABAB, AAA, AB : 13 24
		 * 3. 모르겠어서 검색함
		 * 4. 스택이 비어있으면 첫 단어 넣기
		 * 5. 스택의 맨 위 단어와 다음 단어가 일치하면 제거, 일치하지 않으면 스택에 넣기
		 * 6. 남아있는 단어가 없으면 좋은 단어임.
		 *    => 붙어있는게 다 지워진다면 떨어져있어도 겹치지 않으니까?
		 * */
		for (int i = 0; i < num; i++) {
			String str = br.readLine();
			Stack<Character> stack = new Stack<>();

			if (str.length() % 2 == 0) {

				for (int j = 0; j < str.length(); j++) {

					char item = str.charAt(j);

					if (!stack.isEmpty() && stack.peek() == item) {
						stack.pop();
					} else {
						stack.push(item);
					}
				}

				if (stack.isEmpty()) {
					count++;
				}
			}
		}

		System.out.print(count);
	}

	private static int[] readLine(BufferedReader br) throws IOException {
		return Arrays.stream(br.readLine().split(" "))
				.mapToInt(Integer::parseInt)
				.toArray();
	}
}