import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static boolean[] visit;
	static int[] arr;
	static int N;
	static int M;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		/*
		 * 혼자 풀어보려다 실패
		 * 문제 유형 : 백트래킹
		 * -> 브루트포스가 모든 경우의 수를 탐색하는 것이라면, 이놈은 모든 경우의 수를 탐색하지만, 가능성이 없는놈은 탐색을 안함
		 * 1. 방법이 가능성이 있는지 없는지를 판단하기 위한 boolean visit[] 생성
		 * 2. 1 ~ 4 까지 숫자를 담을 M 크기의 배열 생성
		 * 3. calculrator 메소드 생성, 회차를 기록할 count 전달
		 * 4. 0 ~ N 까지 반복, arr[i] 에 현재 숫자를 입력하고, visit[i] 를 true 로 변경
		 * 5. arr 에 1,2,3,4 기록 후 visit[3] 을 false 로 변경, count = 4 도달 후 sb 에 입력, 메소드 종료
		 * 6. arr[2] 에 3 입력한 메소드 실행, i=3 일 때 visit[3] 이 false 이므로, arr[2] = 4 만들고 visit[2] 를 false 로 변경
		 * 7. 6번 메소드가 호출한 calculrator 실행, count 는 3.
		 * 8. visit[2] 는 false 이므로, arr[3] = 3. 현재 arr = { 1, 2, 4, 3 }
		 * 9. 이 과정을 반복
		 * */

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		arr = new int[M];
		visit = new boolean[N];

		if (M == 1) {
			for (int i = 1; i <= N; i++) {
				sb.append(i).append('\n');
			}
		} else {
			calculrator(0);
		}

		System.out.println(sb);
	}

	private static void calculrator(int count) {

		if (M == count) {
			for (int i : arr) {
				sb.append(i).append(' ');
			}
			sb.append('\n');
		} else {

			for (int i = 0; i < N; i++) {
				if (!visit[i]) {
					visit[i] = true;
					arr[count] = i + 1;
					calculrator(count + 1);
					visit[i] = false;
				}
			}
		}
	}

	private static int[] readLine(BufferedReader br) throws IOException {
		return Arrays.stream(br.readLine().split(" "))
				.mapToInt(Integer::parseInt)
				.toArray();
	}
}