import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static int answer = 0;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int bookCount = Integer.parseInt(st.nextToken());
		int once = Integer.parseInt(st.nextToken());

		/*
		 * 1. 책갯수 N, 한번에 옮길 수 있는 수 M이 split 에 있음
		 * 2. 가장 먼 M 개의 녀석들을 제일 마지막에 옮겨야함
		 * -> -37,-39 빼고 -29,-28 갖다놓고 오면 58, 2,11 갖다놓고 오면 22, -6 갖다놓고 오면 12 해서 총 92걸음 + 39걸음 : 131걸음
		 * 3. 음수는 음수묶음, 양수는 양수묶음으로 계산해야할듯
		 * -> 예제 2번 보니까 -45,-26,-18 옮기고 -9,-4 옮기고 22 40 50 옮겨야 158 나옴
		 * 4. ㅋㅋ 틀림 ㅠ 예제는 다 맞는데
		 * */

		st = new StringTokenizer(br.readLine());
		List<Integer> positiveNum = new ArrayList<>();
		List<Integer> negativeNum = new ArrayList<>();
		int max = 0;
		int min = 0;

		for (int i = 0; i < bookCount; i++) {
			int target = Integer.parseInt(st.nextToken());
			if (target > 0) {
				positiveNum.add(target);
			} else {
				negativeNum.add(target);
			}
			max = Math.max(max, target);
			min = Math.min(min, target);
		}

		max = Math.abs(min) > max ? min : max;
		positiveNum.sort(Comparator.naturalOrder());
		negativeNum.sort(Comparator.reverseOrder());

//		if (max > 0) {
//			if (once <= positiveNum.size()) {
//
//				for (int i = 0; i < once; i++) {
//					positiveNum.remove(positiveNum.size() - 1);
//				}
//
//			}
//		} else {
//			if (once <= negativeNum.size()) {
//
//				for (int i = 0; i < once; i++) {
//					negativeNum.remove(negativeNum.size() - 1);
//				}
//
//			}
//		}

		if (positiveNum.size() > 1) {
			calculator(once, positiveNum);
		}
		if (negativeNum.size() > 1) {
			calculator(once, negativeNum);
		}

		if (!positiveNum.isEmpty()) {
			answer += positiveNum.get(0) * 2;
		}
		if (!negativeNum.isEmpty()) {
			answer += Math.abs(negativeNum.get(0)) * 2;
		}

//		System.out.println(answer + Math.abs(max));
		System.out.print(answer - Math.abs(max));
	}

	private static void calculator(int once, List<Integer> list) {

		while (list.size() > 1) {
			for (int i = 0; i < once; i++) {
				if (i == 0) {
					answer += Math.abs(list.remove(list.size() - 1)) * 2;
				} else {
					if (!list.isEmpty()) {
						list.remove(list.size() - 1);
					}
				}
			}
		}
	}
}
