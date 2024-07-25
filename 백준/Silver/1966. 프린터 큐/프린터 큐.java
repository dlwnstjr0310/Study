import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int num = Integer.parseInt(br.readLine());

		for (int i = 0; i < num; i++) {

			Queue<String> queue = new ArrayDeque<>();
			String[] arr = br.readLine().split(" ");    // 장수, 관심사 번호
			String[] paperValue = br.readLine().split(" "); // 우선순위 중요도

			String paperCount = arr[0];
			int targetIndex = Integer.parseInt(arr[1]);

			int answer = 1;

			for (int j = 0; j < Integer.parseInt(paperCount); j++) {
				queue.add(paperValue[j]);
			}

			while (!queue.isEmpty()) {
				String str = queue.stream().max(String::compareTo).get();

				String currentValue = queue.poll();

				if (str.equals(currentValue) && targetIndex == 0) {
					break;
				} else if (str.equals(currentValue)) {
					answer++;
					targetIndex--;
					continue;
				} else if (targetIndex == 0) {
					targetIndex += queue.size();
				} else {
					targetIndex--;
				}
				queue.add(currentValue);
			}
			sb.append(answer)
					.append('\n');
		}

		System.out.print(sb);
	}
}