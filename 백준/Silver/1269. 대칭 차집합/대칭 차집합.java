import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());

		int Alength = Integer.parseInt(st.nextToken());
		int Blength = Integer.parseInt(st.nextToken());

		Set<Integer> set = new HashSet<>();
		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < Alength; i++) {
			set.add(Integer.parseInt(st.nextToken()));
		}

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < Blength; i++) {
			int num = Integer.parseInt(st.nextToken());
			if (set.contains(num)) {
				set.remove(num);
			} else {
				set.add(num);
			}
		}

		System.out.println(set.size());

	}
}