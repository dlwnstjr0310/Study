import java.io.*;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		StringBuilder sb = new StringBuilder();

		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());

		if (a == b && b == c) {
			sb.append(10000 + (a * 1000));
		} else if (a == b || b == c || a == c) {
			int money = a == b ? a : c;
			sb.append(1000 + (money * 100));
		} else {
			int money = Math.max(a, Math.max(b, c));
			sb.append(money * 100);
		}

		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
}