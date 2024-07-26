import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int number = Integer.parseInt(br.readLine());
		int mod = 1_234_567_891;
		Map<Integer, BigInteger> map = new HashMap<>();

		for (int i = 1; i < 50; i++) {

			BigInteger value = BigInteger.ONE;

			if (map.containsKey(i - 1)) {
				value = map.get(i - 1)
						.multiply(BigInteger.valueOf(31))
						.mod(BigInteger.valueOf(mod));
			} else {
				for (int j = 0; j < i; j++) {
					value = value
							.multiply(BigInteger.valueOf(31))
							.mod(BigInteger.valueOf(mod));
				}
			}

			map.put(i, value);
		}

		BigInteger sum = BigInteger.ZERO;
		String str = br.readLine();

		for (int i = 0; i < number; i++) {
			int num = (int) str.charAt(i) - 96;

			if (i > 0) {
				sum = sum.add(
						BigInteger.valueOf(num).multiply(map.get(i))
				).mod(BigInteger.valueOf(mod));
			} else {
				sum = sum.add(BigInteger.valueOf(num));
			}
		}

		System.out.println(sum);
	}
}