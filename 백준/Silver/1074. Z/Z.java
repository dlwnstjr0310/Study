import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	static int count = 0;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int[] arr = readLine(br);

		/*
		 * 생각 흐름
		 * 1. 우선 하라는대로 적기
		 * 2. 문제 이해를 잘못해서 두시간을 이상한 규칙에 매달렸음.. 남은거라곤 length/2 <= r or c 면 사분면을 이동한것..
		 *    => r 이 크면 오른쪽, c 가 크면 아래로
		 * 3. 4x4 사이즈의 3행 1열은 3사분면, 8x8 사이즈의 7행 7열은 4사분면, 16x16 사이즈의 7행 7열은 1사분면임
		 * 4. 2 3 1 의 경우 (1,1) 을 넘어가면 사분면을 이동함. 3사분면의 마지막이니까 4+4+4-1
		 * 5. 3 7 7 의 경우 (3,3) 을 넘어갔고, 둘 다 넘어갔으니 4사분면임. 16+16+16+16-1
		 * 6. 4 7 7 의 경우 (7,7) 을 넘지않아 1사분면, 64-1
		 * 7. 10 511 511 의 경우 (511,511) 을 넘지않아 1사분면, 262144-1
		 * 8. 10 512 512 의 경우 (511,511) 을 넘어 4사분면, 262144+262144+262144+262144
		 * 9. 그럼 2 2 1 의 경우 (1,1) 을 넘어갔으니 2사분면, 2사분면 안에서 1사분면이고 값은 4임
		 * 10. 10 511 512 의 경우 3사분면, 그 안에서 2사분면, 그 안에서 2사분면, 그 안에서 2사분면,,,,
		 *    => 262144+262144+262144+65536+65536+16384+16384+4096+4096+2048+2048+1024+1024+512+512+256+256+128+128+64+64+32+32+16+16+8+8-2
		 * 이걸 어떻게 적지?
		 * */

		int N = arr[0];
		int r = arr[1];
		int c = arr[2];

		int length = (int) Math.pow(2, N);

		sb.append(findPoint(r, c, length));
		System.out.println(sb);
	}

	private static int findPoint(int row, int col, int size) {
		if (size == 1) {
			return count;
		}

		int halfLength = size / 2;

		if (row < halfLength && col < halfLength) {
			findPoint(row, col, halfLength);
		} else if (row < halfLength && halfLength <= col) {
			count += halfLength * halfLength;
			findPoint(row, col - halfLength, halfLength);
		} else if (col < halfLength && halfLength <= row) {
			count += halfLength * halfLength * 2;
			findPoint(row - halfLength, col, halfLength);
		} else {
			count += halfLength * halfLength * 3;
			findPoint(row - halfLength, col - halfLength, halfLength);
		}

		return count;
	}

	private static int[] readLine(BufferedReader br) throws IOException {
		return Arrays.stream(br.readLine().split(" "))
				.mapToInt(Integer::parseInt)
				.toArray();
	}
}