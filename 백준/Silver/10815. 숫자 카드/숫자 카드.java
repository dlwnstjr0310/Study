import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
//		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(st.nextToken());
		Set<Integer> cardList = new HashSet<>();

		st = new StringTokenizer(bf.readLine());

		for (int i = 0; i < n; i++) {
			cardList.add(Integer.parseInt(st.nextToken()));
		}

		int m = Integer.parseInt(bf.readLine());
		st = new StringTokenizer(bf.readLine());

		bf.close();

		for (int i = 0; i < m; i++) {

			sb.append(
					cardList.contains(Integer.parseInt(st.nextToken())) ? 1 : 0
			).append(' ');
		}

		System.out.println(sb);
//		bw.write(sb.toString() + '\n');
//		bw.flush();
//		bw.close();
	}
}