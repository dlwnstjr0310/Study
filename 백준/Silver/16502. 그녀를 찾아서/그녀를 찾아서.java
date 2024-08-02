import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int num = Integer.parseInt(br.readLine());
		double[] percent = new double[]{1.0, 1.0, 1.0, 1.0};
		double[] answer = new double[4];
		List<List<Node>> list = new ArrayList<>();

		/*
		 * 1. 초기 확률 25% 씩 나눠가짐
		 * 2. 기존 확률 * 이동확률 : 가능성
		 * -> C->A 가 60% 니까, 25 * 0.6 = 15; 10분 후 A 에 있을 확률 : 15%
		 * 3. 매장은 4개 고정. 이걸 코드로...?
		 * */

		int line = Integer.parseInt(br.readLine());

		for (int i = 0; i < 4; i++) {
			list.add(new ArrayList<>());
		}

		for (int i = 0; i < line; i++) {
			String[] split = br.readLine().split(" ");
			int first = conversion(split[0]);
			int second = conversion(split[1]);
			double percentage = Double.parseDouble(split[2]);

			list.get(first).add(new Node(second, percentage));
		}

		for (int i = 0; i < num; i++) {

			for (int j = 0; j < percent.length; j++) {
				// 여기서 percent[] 를 곱해서 answer[] 에 저장해주기
				List<Node> nodes = list.get(j);

				for (Node node : nodes) {
					answer[node.to] += percent[j] * node.percent;
				}

			}

			for (int j = 0; j < answer.length; j++) {
				percent[j] = answer[j];
				answer[j] = 0;
			}

		}

		for (int i = 0; i < percent.length; i++) {
			sb.append(percent[i] / percent.length * 100).append('\n');
		}

		System.out.print(sb);
	}

	static int conversion(String target) {

		int result;

		switch (target) {
			case "A":
				result = 0;
				break;
			case "B":
				result = 1;
				break;
			case "C":
				result = 2;
				break;
			default:
				result = 3;
		}
		return result;
	}

	static class Node {
		int to;
		double percent;

		public Node(int to, double percent) {
			this.to = to;
			this.percent = percent;
		}

	}
}