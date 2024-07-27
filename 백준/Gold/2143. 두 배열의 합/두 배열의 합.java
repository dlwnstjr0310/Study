import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		Map<Integer, Integer> firstMap = getArrayMap(Integer.parseInt(br.readLine()), br.readLine().split(" "));
		Map<Integer, Integer> secondMap = getArrayMap(Integer.parseInt(br.readLine()), br.readLine().split(" "));

		long answer = 0;
		for (Map.Entry<Integer, Integer> entry : firstMap.entrySet()) {

			/*
			 * 1. 목표치인 T에서 firstMap의 현재 키값을 빼면 필요한 값을 알 수 있음
			 * -> T(5) - map.getKey(1) = 4
			 * 2. secondMap 에 '4' 라는 key 값이 존재하는지 확인
			 * 3. 존재한다면 곱해서 answer에 저장
			 * -> ex) 1312 / 1312 일 때
			 *      firstMap : 1=1, 2=1, 3=2, 4=2, 5=1, 6=1, 7=1
			 *      secondMap : 1=1, 2=1, 3=2, 4=2, 5=1, 6=1, 7=1
			 * -> T - key = 1 일때 : 1+3 +1, 3+1 +1, 1 +1+3, 1 +3+1 해서 총 4개, 2*2 개.
			 * -> A[1] + A[2] + B[1], A[2] + A[3] + B[1], A[3] + B[1] + B[2], A[3] + B[2] + B[3] 임.
			 * */
			int otherKey = T - entry.getKey();
			int otherValue = 0;

			if (secondMap.containsKey(otherKey)) {
				otherValue = secondMap.get(otherKey);
			}

			answer += (long) entry.getValue() * otherValue;
		}

		System.out.println(answer);
	}

	private static Map<Integer, Integer> getArrayMap(int length, String[] arr) {
		Map<Integer, Integer> arrayMap = new HashMap<>();

		/*
		 * 목표 : A[] = {1,3,1,2} 가 들어오면 맵에 부배열을 저장하기
		 * -> A 의 부배열은 1,2,3,1+3,3+1,1+2 (연속된 숫자의 합)
		 * -> 저장되는 형태는 1=1, 2=1, 3=2 (3,1+2) , 4=2 (1+3,3+1)
		 * */
		for (int i = 0; i < length; i++) {

			int sum = 0;

			for (int j = i; j < length; j++) {
				sum += Integer.parseInt(arr[j]);

				arrayMap.put(sum, arrayMap.getOrDefault(sum, 0) + 1);
			}
		}

		return arrayMap;
	}
}