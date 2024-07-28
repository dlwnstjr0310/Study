import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] arr = br.readLine().split(" ");

		int num = Integer.parseInt(arr[0]);
		int target = Integer.parseInt(arr[1]);
		int[] targetArr = new int[num];

		String[] nextLine = br.readLine().split(" ");
		for (int i = 0; i < num; i++) {
			targetArr[i] = Integer.parseInt(nextLine[i]);
		}

		selectionSort(targetArr, target);

		System.out.println(sb);
	}

	private static void selectionSort(int[] targetArr, int target) {

		int[] arr = new int[2];
		int count = 0;
		for (int i = targetArr.length - 1; i > 0; i--) {

			int maxIdx = i;

			for (int j = 0; j < i; j++) {
				if (targetArr[maxIdx] < targetArr[j]) {
					maxIdx = j;
				}
			}

			if (maxIdx != i) {
				int temp = targetArr[i];
				targetArr[i] = targetArr[maxIdx];
				targetArr[maxIdx] = temp;
				count++;
			}
			if (count == target) {
				arr[0] = Math.min(targetArr[maxIdx], targetArr[i]);
				arr[1] = Math.max(targetArr[i], targetArr[maxIdx]);
				break;
			}
		}

		if (count < target) {
			sb.append("-1");
		} else {
			sb.append(arr[0])
					.append(' ')
					.append(arr[1]);
		}
	}
}