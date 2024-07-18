import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int num = Integer.parseInt(bf.readLine());

		/*
		 * 첫 줄엔 별 1 + 공백 8 + 별 1 , 두번째 줄엔 별 2 + 공백 6 + 별 2,,,
		 * 반복마다 별은 1 2 3 4 , 공백은 4 3 2 1 형식으로
		 * */
		for (int i = 1; i <= num; i++) {
			sb.append("*".repeat(Math.max(0, i)));
			sb.append("  ".repeat(Math.max(0, num - i)));
			sb.append("*".repeat(Math.max(0, i))).append('\n');
		}

		/*
		 * 위에서 별 10개까지 찍었으니, 4부터 시작
		 * 반복마다 별은 4 3 2 1 , 공백은 1 2 3 4 형식으로
		 * */
		for (int i = num - 1; i > 0; i--) {
			sb.append("*".repeat(Math.max(0, i)));
			sb.append("  ".repeat(Math.max(0, num - i)));
			sb.append("*".repeat(Math.max(0, i))).append('\n');
		}

		System.out.println(sb);
	}
}