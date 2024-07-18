import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		StringBuilder sb = new StringBuilder();

		/*
		 * 1. N,M 과 같은 크기의 배열이 주어진다.
		 * 2. 다음으로 연산 횟수가 주어진다.
		 * 3. i,j,x,y 가 주어진다. ( 1씩 빼야함 )
		 * */

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[][] arr = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		st = new StringTokenizer(bf.readLine());
		int K = Integer.parseInt(st.nextToken());

		for (int t = 0; t < K; t++) {
			st = new StringTokenizer(bf.readLine());
			int sum = 0;

			int i = Integer.parseInt(st.nextToken()) - 1;
			int j = Integer.parseInt(st.nextToken()) - 1;
			int x = Integer.parseInt(st.nextToken()) - 1;
			int y = Integer.parseInt(st.nextToken()) - 1;

			for (int k = i; k <= x; k++) {
				for (int l = j; l <= y; l++) {
					sum += arr[k][l];
				}
			}
			sb.append(sum).append('\n');
		}

		System.out.println(sb);
	}
}