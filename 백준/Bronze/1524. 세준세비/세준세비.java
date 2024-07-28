import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static int sejun;
	static int sebi;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int num = Integer.parseInt(br.readLine());

		for (int i = 0; i < num; i++) {

			br.readLine();

			setUp(br);

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

	private static void setUp(BufferedReader br) throws IOException {
		String[] count = br.readLine().split(" ");
		sejun = 0;
		sebi = 0;

		for (int j = 0; j < 2; j++) {
			String[] power = br.readLine().split(" ");

			if (j == 0) {
				for (int k = 0; k < Integer.parseInt(count[0]); k++) {
					if (sejun < Integer.parseInt(power[k])) {
						sejun = Integer.parseInt(power[k]);
					}
				}
			} else {
				for (int k = 0; k < Integer.parseInt(count[1]); k++) {
					if (sebi < Integer.parseInt(power[k])) {
						sebi = Integer.parseInt(power[k]);
					}
				}
			}
		}
	}
}