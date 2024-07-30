import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int num = Integer.parseInt(br.readLine());
		Deque<Integer> q = new ArrayDeque<>();
		int maxLength = 0;
		int lastNum = Integer.MAX_VALUE;

		for (int i = 0; i < num; i++) {

			String[] arr = br.readLine().split(" ");

			if (arr[0].equals("1")) {
				// 학생 대기
				int studentNum = Integer.parseInt(arr[1]);
				q.offer(studentNum);

				if (q.size() >= maxLength) {
					// 최대 크기가 같은게 여러개면 뒤 번호가 작은거 출력
					if (q.size() > maxLength) {
						maxLength = q.size();
						lastNum = q.peekLast();
					} else if (q.size() == maxLength) {
						/*
						 * 여기가 문제인것같은디
						 * maxLength 가 2 -> 3 으로 넘어갔을 때 lastNum 을 반드시 수정해줘야함
						 * 지금은 2 -> 3 으로 넘어가도 num 이 더 작으면 수정안해줌
						 * */
						if (lastNum > q.peekLast()) {
							lastNum = q.peekLast();
						}
					}
				}
			} else {
				// 밥주기
				if (!q.isEmpty()) {
					q.poll();
				}
			}
		}

		// 최대 크기 + 학생 번호 작은거 출력
		System.out.println(maxLength + " " + lastNum);
	}
}