import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int num = Integer.parseInt(br.readLine());

		for (int i = 0; i < num; i++) {

			String[] split = br.readLine().split(" ");
			int nationCount = Integer.parseInt(split[0]);
			int planeCount = Integer.parseInt(split[1]);

			for (int j = 0; j < planeCount; j++) {
				br.readLine();
			}

			sb.append(nationCount - 1).append('\n');
		}

		System.out.print(sb);
	}
}