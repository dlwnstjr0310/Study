import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException {

		/*
		 * 1. 입력 : 점의 개수 N, 선분의 개수 M. 둘째줄에는 점의 좌표가 주어지고, 이후 M 개의 줄에 선분의 시작점과 끝점이 주어짐.
		 *
		 * 2. 기능 : 선분 위에 점이 몇개 있는지 체크하기
		 * 2-1 : 정렬해야하니까 TreeSet 으로 선언, 예제 기준 1~10 사이의 점은 1,3,10 임. ceiling 과 floor 를 이용하자.
		 * 2-2 : ceiling/floor 는 TreeSet 의 기능이기 때문에, 타입도 TreeSet 으로 선언해주기
		 * 2-3 : 시작점 <= 점 <= 끝점 의 형태기 때문에, floor(start) <= point <= ceiling(end) 일 때 cnt++
		 * -> floor : 전달받은 값보다 작거나 같은 요소중 가장 큰값 리턴
		 * -> ceiling : 전달받은 값보다 크거나 같은 요소중 가장 작은값 리턴
		 * 근데 시간초과나옴 ㅠ
		 *
		 * 2-4 : set 이 아니라 다른 방법으로 해야할듯 ㅠ 배열로 해보자
		 * 2-5 : 배열도 그냥 찾으면 시간초과가 나온다. 이분 탐색을 사용해야할듯
		 * 2-6 : 바로 틀려서 조건을 다시 읽어보기 시작함
		 *
		 * 3. 출력 : 선분 위에 점의 갯수 출력
		 * */

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		String[] split = br.readLine().split(" ");

		int N = Integer.parseInt(split[0]);
		int M = Integer.parseInt(split[1]);

		int[] position = new int[N];
		String[] target = br.readLine().split(" ");

		for (int i = 0; i < N; i++) {
			position[i] = Integer.parseInt(target[i]);
		}

		Arrays.sort(position);

		for (int i = 0; i < M; i++) {
			String[] arr = br.readLine().split(" ");

			int result = getResult(arr, position);

			sb.append(result).append('\n');
		}

		System.out.print(sb);
	}

	private static int getResult(String[] arr, int[] position) {

		int start = Integer.parseInt(arr[0]);
		int end = Integer.parseInt(arr[1]);

		int minIdx = 0;
		int maxIdx = position.length - 1;

		while (minIdx <= maxIdx) {
			int idx = (minIdx + maxIdx) / 2;

			if (position[idx] < start) {
				minIdx = idx + 1;
			} else {
				maxIdx = idx - 1;
			}
		}

		int startIdx = minIdx;

		minIdx = 0;
		maxIdx = position.length - 1;

		while (minIdx <= maxIdx) {
			int idx = (minIdx + maxIdx) / 2;

			if (position[idx] > end) {
				maxIdx = idx - 1;
			} else {
				minIdx = idx + 1;
			}
		}

		int endIdx = maxIdx + 1;

		return endIdx - startIdx;
	}
}
