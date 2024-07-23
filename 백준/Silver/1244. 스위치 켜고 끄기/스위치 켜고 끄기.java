import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int length = Integer.parseInt(br.readLine());
		int[] arr = new int[length];
		StringTokenizer st = new StringTokenizer(br.readLine());

		for (int i = 0; i < length; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int count = Integer.parseInt(br.readLine());

		for (int i = 0; i < count; i++) {
			st = new StringTokenizer(br.readLine());
			String gender = st.nextToken();
			int switchNumber = Integer.parseInt(st.nextToken());

			if (gender.equals("1")) {
				// 스위치 번호가 자기가 받은 수의 배수이면, 그 스위치의 상태를 바꾼다.
				for (int j = switchNumber; j <= length; j += switchNumber) {
					arr[j - 1] = reverse(arr[j - 1]);
				}
			} else {
				// 자기가 받은 수와 같은 번호가 붙은 스위치를 중심으로 좌우가 대칭이면서 가장 많은 스위치를 포함하는 구간을 찾아서,
				// 그 구간에 속한 스위치의 상태를 모두 바꾼다.
				switchNumber = switchNumber - 1;

				arr[switchNumber] = reverse(arr[switchNumber]);

				for (int j = 1; j < length; j++) {
					int before = switchNumber - j;
					int after = switchNumber + j;

					if (before >= 0 && after <= length - 1) {
						if (arr[before] == arr[after]) {
							arr[before] = reverse(arr[before]);
							arr[after] = reverse(arr[after]);
						} else {
							break;
						}
					} else {
						break;
					}
				}
			}
		}

		for (int i = 1; i <= length; i++) {

			sb.append(arr[i - 1]).append(' ');

			if (i % 20 == 0) {
				sb.append('\n');
			}
		}

		System.out.println(sb);
	}

	private static int reverse(int a) {
		if (a == 0) {
			return 1;
		} else {
			return 0;
		}
	}
}