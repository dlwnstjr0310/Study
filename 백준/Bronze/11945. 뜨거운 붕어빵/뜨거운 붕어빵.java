import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		StringBuilder sb = new StringBuilder();

		/*
		 * 붕어빵 좌우 뒤집기 문제
		 * String 을 뒤집자
		 * */

		int repeat = Integer.parseInt(st.nextToken());
		int length = Integer.parseInt(st.nextToken());

		for (int i = 0; i < repeat; i++) {
			StringBuilder str = new StringBuilder(bf.readLine());

			sb.append(str.reverse()).append('\n');
		}

		System.out.println(sb);
	}
}