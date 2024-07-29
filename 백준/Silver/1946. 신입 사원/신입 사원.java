import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int num = Integer.parseInt(br.readLine());

		for (int i = 0; i < num; i++) {

			int count = Integer.parseInt(br.readLine());
			int[] score = new int[count + 1];

			for (int j = 0; j < count; j++) {

				String[] str = br.readLine().split(" ");

				int paper = Integer.parseInt(str[0]);
				int interview = Integer.parseInt(str[1]);

				score[paper] = interview;

			}

			int answer = 1;
			int highScore = score[1];

			for (int j = 2; j <= count; j++) {
				if (highScore > score[j]) {
					highScore = score[j];
					answer++;
				}
			}

			sb.append(answer).append('\n');
		}
		System.out.print(sb);
	}
}