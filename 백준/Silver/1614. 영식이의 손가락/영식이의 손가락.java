import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        
		int fingerNumber = Integer.parseInt(bf.readLine());
		int num = Integer.parseInt(bf.readLine());

		if (num == 0) {
			System.out.println(fingerNumber - 1);
		} else {
			long count;

			if (fingerNumber == 1) {
				count = num * 8L;
			} else if (fingerNumber == 2) {
				// 홀 -> 짝 일때 6 증가, 짝 -> 홀일때 2 증가
				if (num % 2 != 0) {
					count = num * 4L + 3;
				} else {
					count = num * 4L + 1;
				}
			} else if (fingerNumber == 3) {
				// 홀 -> 짝, 짝 -> 홀 무관하게 4 증가
				count = num * 4L + 2;
			} else if (fingerNumber == 4) {
				// 홀 -> 짝 일때 2 증가, 짝 -> 홀 일 때 6 증가
				if (num % 2 != 0) {
					count = num * 4L + 1;
				} else {
					count = num * 4L + 3;
				}
			} else {
				count = num * 8L + 4;
			}

			System.out.println(count);
		}

	}
}