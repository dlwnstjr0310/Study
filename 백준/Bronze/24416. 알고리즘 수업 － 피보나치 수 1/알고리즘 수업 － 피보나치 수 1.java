import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	/*
	 * 메모이제이션 기법?
	 * 이전에 계산한 값을 저장하여 다시 계산하지 않도록 하여 속도를 빠르게 하는 방법.
	 * count 와 f 를 두 가지 메소드에서 같이 사용하기 위해 전역변수로 선언했는디, 이게 맞나봄.
	 * fib 는 탑다운 방식, fibbo~ 는 바텀 업 방식인듯
	 * 탑 다운 : 큰 문제 작은 문제로 나누어 푸는데, 재귀 호출을 사용해서 푼다.
	 * 바텀 업 : 작은 문제부터 시작하여 큰 문제를 풀어나감. 반복문을 통해 해를 계산하고, 이를 저장해둔다.
	 * -> 탑 다운은 그냥 재귀호출, 바텀 업은 이전 계산 결과를 변수에 저장해두기 때문에 효율이 좋은가보다.
	 * */
	static int count1;
	static int count2;
	static int[] f;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int num = Integer.parseInt(br.readLine());

		f = new int[num];
		count1 = 0;
		count2 = 0;

		fib(num);
		fibbonacci(num);

		System.out.println(count1 + " " + count2);
	}

	public static int fib(int n) {
		if (n == 1 || n == 2) {
			count1++;
			return 1;
		} else {
			return fib(n - 1) + fib(n - 2);
		}
	}

	static int fibbonacci(int n) {
		f[0] = 1;
		f[1] = 1;
		for (int i = 2; i < n; i++) {
			count2++;
			f[i] = f[i - 1] + f[i - 2];
		}

		return f[n - 1];
	}
}