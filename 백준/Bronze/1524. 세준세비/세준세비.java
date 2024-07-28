import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int num = Integer.parseInt(br.readLine());

		for (int i = 0; i < num; i++) {

			br.readLine();

			String[] count = br.readLine().split(" ");
			int sejun = 0;
			int sebi = 0;

			for (int j = 0; j < 2; j++) {
				String[] power = br.readLine().split(" ");

				if (j == 0) {
					for (int k = 0; k < Integer.parseInt(count[0]); k++) {
						sejun = Math.max(sejun, Integer.parseInt(power[k]));
					}
				} else {
					for (int k = 0; k < Integer.parseInt(count[1]); k++) {
						sebi = Math.max(sebi, Integer.parseInt(power[k]));
					}
				}
			}

			if (sejun > sebi) {
				sb.append('S').append('\n');
			} else if (sejun < sebi) {
				sb.append('B').append('\n');
			} else {
				sb.append('S').append('\n');
			}
		}
		System.out.print(sb);
	}
}