import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		StringBuilder sb = new StringBuilder();

		/*
		 * a 개의 숫자를 배열에 저장하고
		 * 순서대로 배열의 요소를 더해서 b 가 되는순간을 세자
		 * */
		int length = Integer.parseInt(st.nextToken());
		int goal = Integer.parseInt(st.nextToken());

		int[] arr = new int[length];
		st = new StringTokenizer(bf.readLine());

		for (int i = 0; i < length; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		/*
		 * 여기서 배열의 요소를 순서대로 더하자
		 * 1 + 2 했을 때 goal 보다 적으면 1 + 2 + 3 을 해야함
		 * => 그냥 반복문으로 했더니 2%에서 실패함
		 * 투 포인터 알고리즘 활용하기
		 * */

		int count = 0;
		int sum = 0;
		int slowIndex = 0;
		int fastIndex = 0;

		while (true) {
			if (sum >= goal) {
				sum -= arr[slowIndex++];
			} else if (fastIndex == length) {
				break;
			} else {
				sum += arr[fastIndex++];
			}
			if (sum == goal) {
				count++;
			}
		}

		System.out.println(count);
	}
}