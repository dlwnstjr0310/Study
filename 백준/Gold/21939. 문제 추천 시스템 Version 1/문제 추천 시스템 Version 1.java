import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Main {

	/*
	 * recommend x : x 가 1인경우 가장 어려운문제, 여러개일경우 가장 번호가 큰 문제
	 *               0인경우 가장 쉬운 문제, 여러개일경우 가장 번호가 작은 문제
	 *
	 * add P L : 추천 문제 리스트에 난이도가 L인 문제번호 P 를 추가.
	 *           추천 문제 리스트에 없는 P만 주어짐. 단, 이전에 추천문제 리스트에 있던 문제번호가 다른 난이도로 다시 들어올 수 있음.
	 *
	 * solved P : 추천 문제 리스트에서 문제번호 P 를 제거.
	 *            추천 문제 리스트에 있는 P 만 입력으로 주어진다.
	 *
	 * recommend 는 문제 리스트에 문제가 하나 이상 있을때만 주어짐
	 * solved 는 문제 리스트에 문제 번호가 하나 이상 있을때만 주어짐
	 * */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int num = Integer.parseInt(br.readLine());

		/*
		 * 1. 문제 번호는 큐로 관리하고, 문제 가져오는건 맵으로 하면 될듯?
		 *    난이도가 같을 수 있으니 맵의 키는 문제 번호로 하자.
		 * */
		// 문제번호 - 난이도
		PriorityQueue<Integer[]> hardQ = new PriorityQueue<>((a, b) -> {
			if (b[0] != a[0]) {
				return b[0] - a[0];
			}
			return b[1] - a[1];
		});
		PriorityQueue<Integer[]> easyQ = new PriorityQueue<>((a, b) -> {
			if (a[0] != b[0]) {
				return a[0] - b[0];
			}
			return a[1] - b[1];
		});
		Map<Integer, Integer> map = new HashMap<>();

		for (int i = 0; i < num; i++) {
			String[] arr = br.readLine().split(" ");

			map.put(Integer.parseInt(arr[0]), Integer.parseInt(arr[1]));
			hardQ.offer(new Integer[]{Integer.parseInt(arr[1]), Integer.parseInt(arr[0])});
			easyQ.offer(new Integer[]{Integer.parseInt(arr[1]), Integer.parseInt(arr[0])});
		}

		num = Integer.parseInt(br.readLine());

		for (int i = 0; i < num; i++) {
			String[] arr = br.readLine().split(" ");

			if (arr[0].equals("recommend")) {

				if (arr[1].equals("1")) {
					if (map.containsKey(hardQ.peek()[1])) {
						sb.append(hardQ.peek()[1]).append('\n');
					}
				} else {
					if (map.containsKey(easyQ.peek()[1])) {
						sb.append(easyQ.peek()[1]).append('\n');
					}
				}

			} else if (arr[0].equals("solved")) {
				int target = Integer.parseInt(arr[1]);

				map.remove(target);

				if (hardQ.peek()[1] == target) {
					hardQ.poll();
				}
				if (easyQ.peek()[1] == target) {
					easyQ.poll();
				}
			} else {
				map.put(Integer.parseInt(arr[1]), Integer.parseInt(arr[2]));
				hardQ.offer(new Integer[]{Integer.parseInt(arr[2]), Integer.parseInt(arr[1])});
				easyQ.offer(new Integer[]{Integer.parseInt(arr[2]), Integer.parseInt(arr[1])});
			}
		}

		System.out.print(sb);
	}
}
