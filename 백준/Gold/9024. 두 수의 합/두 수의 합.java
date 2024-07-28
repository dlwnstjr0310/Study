import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int num = Integer.parseInt(br.readLine());

		for (int i = 0; i < num; i++) {

			String[] split = br.readLine().split(" ");
			int length = Integer.parseInt(split[0]);
			int target = Integer.parseInt(split[1]);

			int[] arr = new int[length];
			String[] targetArr = br.readLine().split(" ");

			for (int j = 0; j < length; j++) {
				arr[j] = Integer.parseInt(targetArr[j]);
			}

			Arrays.sort(arr);
			calculator(arr, target);

		}

		System.out.print(sb);
	}

	private static void calculator(int[] arr, int target) {

		// -7 -4 -3 -2 0 1 2 5 9 12
		int start = 0;
		int end = arr.length - 1;
		int count = 1;
		int result = Integer.MAX_VALUE;

		while (start < end) {

			int sum = arr[start] + arr[end];
			int temp = Math.abs(target - sum);

			if (result > temp) {
				result = temp;
				count = 1;
			} else if (result == temp) {
				count++;
			}
			if (sum < target) {
				start++;
			} else {
				end--;
			}
		}
		/*
		 * 1. arr[start] + arr[end] 를 계산 후 result 에 저장
		 * 2. 기존 result 와 같은 값이 등장하면 count++;
		 * 3. 기존 result 보다 target 에 더 근접한 result 등장 시 교체, count = 1;
		 * */
		sb.append(count).append('\n');
	}
}