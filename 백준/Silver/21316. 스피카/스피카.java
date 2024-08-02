import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {
	public static void main(String[] args) throws IOException {

		/*
		 * 3,4,7,9 만 세가지 연결을 가지고있음
		 * 4와 7 : 한쪽 노드가 리프노드
		 * -> 4 : 나머지 노드가 모두 세가지 연결을 가짐
		 * -> 7 : 나머지 노드중 하나가 두가지 연결을 가짐
		 * */

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		List<List<Integer>> list = new ArrayList<>();

		for (int i = 0; i < 13; i++) {
			list.add(new ArrayList<>());
		}

		for (int i = 0; i < 12; i++) {
			String[] split = br.readLine().split(" ");
			int from = Integer.parseInt(split[0]);
			int to = Integer.parseInt(split[1]);

			list.get(from).add(to);
			list.get(to).add(from);
		}

		for (int i = 1; i <= 12; i++) {
			List<Integer> starList = list.get(i);
			Set<Integer> set = new HashSet<>();

			if (starList.size() == 3) {
				for (Integer target : starList) {
					set.add(list.get(target).size());
				}
			}

			if (set.size() == 3) {
				System.out.println(i);
			}
		}
	}
}