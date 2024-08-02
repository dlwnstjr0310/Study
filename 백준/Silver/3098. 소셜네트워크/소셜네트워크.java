import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		String[] split = br.readLine().split(" ");
		int vertex = Integer.parseInt(split[0]);
		int edge = Integer.parseInt(split[1]);

		int[][] friend = new int[vertex][vertex];

		for (int i = 0; i < edge; i++) {
			String[] arr = br.readLine().split(" ");

			int from = Integer.parseInt(arr[0]) - 1;
			int to = Integer.parseInt(arr[1]) - 1;

			friend[from][to] = 2;
			friend[to][from] = 2;
		}

		/*
		 * 1일차 : 1 -> 3, 2 -> 4, 3 -> 5
		 * 2일차 : 1 -> 4, 1 -> 5, 2 -> 5
		 * 1. 적은대로 코드로 짜보자. 시간이랑 메모리가 불안하긴 한데 우선 계속 리스트 가져오는 식으로
		 * 2. 메모리 초과받음 ㅠ 리스트를 너무많이쓴듯.. 50이라 괜찮을줄알았는데
		 * -> 친구 추가하는 부분에서 boolean 배열 삭제. 아무 의미없었던것같음
		 * 3. 똑같이 메모리초과.. 컬렉션을 좀 없애야할듯. 친구신청하는부분을 없애야할듯?
		 * 4. 새로운 마음으로 다시시작; 배열을 써보자
		 * 5. 진짜 아예모르겠어서 구글링
		 * */

		int days = 0;
		List<Integer> list = new ArrayList<>();

		while (edge < vertex * (vertex - 1) / 2) {

			int count = 0;

			for (int i = 0; i < vertex; i++) {
				for (int j = i + 1; j < vertex; j++) {

					if (friend[i][j] != 0) {
						continue;
					}

					for (int k = 0; k < vertex; k++) {
						if (friend[i][k] == 2 && friend[k][j] == 2) {
							friend[i][j] = 1;
							friend[j][i] = 1;
							count++;
							break;
						}
					}
				}
			}

			list.add(count);
			edge += count;

			for (int i = 0; i < vertex; i++) {
				for (int j = 0; j < vertex; j++) {
					if (friend[i][j] == 1) {
						friend[i][j] = 2;
					}
				}
			}
			days++;
		}

		sb.append(days).append('\n');

		for (int i = 0; i < list.size(); i++) {
			sb.append(list.get(i)).append('\n');
		}

		System.out.print(sb);
	}
}