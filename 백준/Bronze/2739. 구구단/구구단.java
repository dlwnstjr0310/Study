import java.io.*;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		StringBuilder sb = new StringBuilder();


		int num = Integer.parseInt(st.nextToken());

		for (int i = 1; i <= 9; i++) {
			sb.append(num).append(" * ").append(i).append(" = ").append(num * i).append('\n');
		}

		System.out.println(sb);
	}
}