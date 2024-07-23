import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int[] arr = new int[3];

		for (int i = 0; i < 3; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int walkRange = arr[0];
		int sleppRange = arr[1];
		int goal = arr[2];

		int day = (goal - sleppRange) / (walkRange - sleppRange);

		if ((goal - sleppRange) % (walkRange - sleppRange) != 0) {
			day++;
		}
		System.out.println(day);
	}
}