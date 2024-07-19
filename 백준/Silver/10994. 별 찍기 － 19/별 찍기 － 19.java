import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int num = Integer.parseInt(br.readLine());
		int length = num * 4 - 3;

		char[][] arr = new char[length][length];

		/*
		 * 생각한 순서
		 * 1. 1 이면 1, 2면 5, 3이면 9, 4면 13, 5면 17, 6은 21, 7은 25  => 1 * 1 , 2 * 2 + 1 , 3 * 3 , 4 * 3 + 1 ?????
		 * 2. 그런게 아니고 2면 가운데에 빈공간이 두개, 3부터는 외곽으로 하나씩 생기는거였음
		 *    => 2 면 5칸, 3이면 양 옆으로 2칸씩 ( +4 ) 임
		 *    => 홀수는 n * 4 - 3 인듯? 짝수는 진짜 모르겠는디..
		 *    => n * 4 - 3 을 짝수에다 써도 맞음
		 * 3. 이걸 구현을 어떻게 하지?
		 *    => 분류가 재귀니까.. 겹겹이 추가하는식이 아닐까? 인풋이 4면 함수를 총 4번 호출하는 식??
		 * 4. 일단 할수있는것부터 해보기
		 *    => 맨 끝은 length-1 , 두번째는 무조건 2개, 세번째는 2개 + (n-1) * 4 - 3
		 * 5. 하다보니까 * 로 한겹, ' ' 로 한겹, * 로 한겹인걸 알아버림
		 * 6. 첫번째는 별로 도배, 두번째는 공백으로 도배, 세번째는 별로 도배 식이니까, 상태를 알려줄 변수가 필요함
		 * 7. 코드를 한줄씩 써내려가다 규칙을 발견함
		 * */

		int count = 0;
		// count % 2 가 0일때마다 별임
		while (count <= length) {
			printStar(count, length, arr);
			count++;
		}

		for (char[] a : arr) {
			System.out.println(a);
		}

	}

	private static void printStar(int count, int length, char[][] arr) {
		for (int i = count; i < length - count; i++) {
			if (count % 2 == 0) {
				arr[count][i] = '*';
				arr[i][count] = '*';
				arr[length - 1 - count][i] = '*';
				arr[i][length - 1 - count] = '*';
			} else {
				arr[count][i] = ' ';
				arr[i][count] = ' ';
				arr[i][length - 1 - count] = ' ';
				arr[length - 1 - count][i] = ' ';
			}
		}
	}
}