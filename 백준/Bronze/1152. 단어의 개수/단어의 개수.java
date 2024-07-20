import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		String[] arr = br.readLine().trim()
				.split(" ");

		int count = 0;

		for (String str : arr) {
			if (str.isBlank()) {
				count++;
			}
		}

		System.out.println(arr.length - count);
	}
}