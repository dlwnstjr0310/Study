import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int M;
	static int[] answer;
	static int[] arr;
	static boolean[] used;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N];
		used = new boolean[N];
		answer = new int[M];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(arr);

		calculator(0);

		System.out.print(sb);
	}

	private static void calculator(int count) {

		/*
		 * 1. 조건은 이전과 거의 동일하나, 동일한 숫자가 아닌 동일한 인덱스가 금지
		 * 2. 한번 사용한 숫자는 사용할 수 없도록 used 배열 생성, 사용 후 true 로 값 변경하기
		 * 3. 사용하지 않은 숫자이고, answer[count] 와 arr[i] 의 값이 다른경우 answer[count] 에 입력 후 cal(count+1) 호출
		 * 4. 위 조건만 있을 경우 4 3 / 1 3 9 9 로 실행하면 1 9 9 다음 3 1 9 가 아닌 3 9 1 이 나옴
		 * 5. if : answer[count] != arr[i] 는 arr[2] 인지 arr[3] 인지 관심이 없기 때문인듯
		 * 6. 조건을 수정했더니 위 예제는 맞았지만, 4 3 / 9 9 9 1 의 경우 오답 출력
		 * 7. 수정 전 : 4 3 / 9 9 9 1 (O) 4 3 / 1 3 9 9 (X)
		 *    수정 후 : 4 3 / 9 9 9 1 (X) 4 3 / 1 3 9 9 (O)
		 * 8. 조건을 나눠서 따로 실행해봐야할듯
		 * 9. 뭔가.. 문제를 잘못 이해하고 있는것 같다는 생각이 들었음.
		 *    4 3 / 9 9 9 1 의 경우 1 9 9 , 1 9 9 , 1 9 9 가 나와야 하는게 아닌가? (3 0 1 , 3 1 2 , 3 0 2)
		 *    if문 조건을 문제 조건으로 착각한듯.
		 * 10. answer[2],answer[3] 에 인덱스가 다른 같은 값의 입력 O, 단 answer 전체가 같은건 X
		 *    -> 인덱스마다 별개로 이전 값을 저장해두면 중복 값으로 교체 없이 사용가능
		 * */

		if (count == M) {
			for (int i : answer) {
				sb.append(i).append(' ');
			}
			sb.append('\n');
		} else {

			int before = 0;

			for (int i = 0; i < N; i++) {
				if (!used[i]) {
					used[i] = true;
					if (before != arr[i]) {
						answer[count] = arr[i];
						before = arr[i];
						calculator(count + 1);
					}
//					System.out.println("자리 : " + count);
//					System.out.println("now answer : " + Arrays.toString(answer));
//					System.out.println("boolean : " + Arrays.toString(used));
//					System.out.println("answer[" + count + "]번 자리에 " + before + " 를 대신해서 " + "arr의 [" + i + "] 인 " + arr[i] + " 가 들어가려고함");
//					System.out.println("==================================");
					used[i] = false;
				}
			}
		}
	}
}