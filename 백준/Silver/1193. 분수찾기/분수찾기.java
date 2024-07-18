import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int num = Integer.parseInt(br.readLine());

		// 정중앙의 좌표는 1, 5, 13, 25, 41, 61, 85, 113, 145,,,
		// +4 +8 +12 +16 +20 +24 +28 +32,,, => for : value += 4 * i 형식으로 뽑아낼 수 있음
		// 곱하기 한 숫자 -1 만큼 분모 작아지고 분자 커짐 -> 이 과정이 끝나면 분자도 작아짐
		// 그럼 받은 숫자랑 가까운 정중앙 좌표에서 벌어진 차이만큼 숫자 더하면 되지않나?
		// 대각선 2번째 끝 숫자는 2/1 or 1/2 , 3번째 끝 숫자는 3/1 or 1/3 임
		// 그냥 대각선에서 계산하면 안되나?

		int line = 1;
		while (num > line) {
			num -= line;
			line++;
		}

		// 대각선이 홀수면 분자 작아 분모 커
		// 대각선이 짝수면 분모 작아 분자 커
		if (line % 2 == 0) {
			System.out.println(num + "/" + (line - num + 1));
		} else {
			System.out.println((line - num + 1) + "/" + num);
		}
	}
}