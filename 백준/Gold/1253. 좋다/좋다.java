import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


		int num = Integer.parseInt(br.readLine());
		String[] split = br.readLine().split(" ");

		int[] arr = new int[num];

		for (int i = 0; i < num; i++) {
			arr[i] = Integer.parseInt(split[i]);
		}

		/*
		 * -1, -2, -2, 0, -1 의 경우
		 * -1, -2 만 조합으로 만들 수 있기 때문에 정답은 4
		 * 0, 0, 1 의 경우
		 * 0 + 0 = 0 이지만 다른 두 수의 합이기때문에 정답은 0개임
		 * 1. 시간초과받음; 뭐가문제지
		 * 2. 아무래도 리스트를 쓰면 안되는듯. 분류가 투포인터니까 배열로 다시 생각해보자
		 * 3. 정렬하고 제일 작은값(arr[0]) + 제일 큰값(arr[num-1]) = 배열에 있는 값이어야 함
		 * -> 배열에 있는 값보다 크면 큰쪽 인덱스 줄이기
		 * -> 배열에 있는 값보다 작으면 작은쪽 인덱스 늘리기
		 * 4. 지금 상태에서 0 0 1 이 3이나옴. [0]+[1] = [0] 이면 안되는걸 깜빡함
		 * -> sum == arr[slow] 포함해주면 되지않을까?
		 * 5. 아니었음. 0 0 0 이 3이나옴 ㅠ
		 * 6. 더한 '값'이 중요한게 아니라 '인덱스'가 중요한거였음.
		 * -> arr[i] == arr[slow] 를 포함하면 되지 않을까?
		 * 7. 이것도 아니었음 ㅠ 생각은 맞는것같은데 코드로 표기를 잘못한것같음.
		 * -> 0 0 0 일때 arr[0] + arr[1] = arr[2] 일때만 계산하라는걸 어떻게 적지?
		 * 8. slow == i || fast == i => break; 면 되지않을까
		 * 9. break 를 걸었더니 i=0 일때 1,2 를 검사를 못하고, continue 를 했더니 무한루프임
		 * */

		Arrays.sort(arr);

		int answer = 0;

		for (int i = 0; i < num; i++) {

			int slow = 0;
			int fast = num - 1;

			while (slow < fast) {

				// arr[slow] + arr[fast] == arr[i] 일 때, i 가 slow 나 fast 면 안댐
				// i = 0 일 때는 1,2,3 만 검사, 1 일때는 0 2 3 만 검사
				if (i == slow && slow + 1 < num) {
					slow++;
				}
				if (fast == i && fast - 1 > 0) {
					fast--;
				}

				int sum = arr[slow] + arr[fast];

				if (arr[i] == sum && i != slow && i != fast) {
					answer++;
					break;
				} else if (arr[i] > sum) {
					// sum 이 arr[i] 보다 작으면 slow 증가
					slow++;
				} else {
					// sum 이 arr[i] 보다 크면 fast 감소
					fast--;
				}
			}
		}
		System.out.print(answer);
	}
}