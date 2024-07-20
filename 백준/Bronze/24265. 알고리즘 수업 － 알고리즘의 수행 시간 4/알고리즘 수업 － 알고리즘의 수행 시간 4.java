import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

		int num = Integer.parseInt(br.readLine());
		long sum = 0;

		for (int i = 0; i < num; i++) {
			sum += i;
		}

        sb.append(sum).append('\n').append(2);
		System.out.println(sb);
	}

}