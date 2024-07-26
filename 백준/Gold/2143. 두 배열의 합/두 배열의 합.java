import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		// 합, 갯수
		Map<Integer, Integer> aMap = new HashMap<>();
		Map<Integer, Integer> bMap = new HashMap<>();

		int A = Integer.parseInt(br.readLine());
		String[] arr = br.readLine().split(" ");

		input(A, arr, aMap, T);

		int B = Integer.parseInt(br.readLine());
		arr = br.readLine().split(" ");
		input(B, arr, bMap, T);

		long answer = 0;

		for (Map.Entry<Integer, Integer> entryA : aMap.entrySet()) {

			int otherKey = T - entryA.getKey();
			Integer otherValue = bMap.get(otherKey);

            if(otherValue != null) {
			answer += ((long) entryA.getValue() * otherValue);
            }
		}

		System.out.println(answer);
	}

	private static void input(int size, String[] arr, Map<Integer, Integer> map, int T) {

		for (int i = 0; i < size; i++) {

			int sum = 0;

			for (int j = i; j < size; j++) {

				sum += Integer.parseInt(arr[j]);
				map.put(sum, map.getOrDefault(sum, 0) + 1);

			}

		}

	}

}
