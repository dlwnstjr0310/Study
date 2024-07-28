import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int num = Integer.parseInt(br.readLine());

		for (int i = 0; i < num; i++) {

			int count = 0;
			String answer = "";
			int length = Integer.parseInt(br.readLine());

			for (int j = 0; j < length; j++) {

				StringTokenizer st = new StringTokenizer(br.readLine());
				String school = st.nextToken();
				int drinkCount = Integer.parseInt(st.nextToken());

				if (count < drinkCount) {
					answer = school;
					count = drinkCount;
				}
			}

			sb.append(answer).append('\n');
		}

		System.out.print(sb);
	}
}