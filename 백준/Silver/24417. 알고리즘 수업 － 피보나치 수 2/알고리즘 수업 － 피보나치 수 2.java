import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int num = Integer.parseInt(br.readLine());
		int modTarget = 1000000007;

		/* 생각한 순서
		 * 1. fib 에서 무조건 시간초과가 나온다.
		 *    얘도 메모이제이션 기법을 사용해야 하는거 아닐까?
		 * 2. 구글링 해봤는데 다 무슨소리인지 모르겠다
		 * 3. 어찌됐건 1번 방법으로 계산하면 안되는거고, 2번 방법으로 계산해야하나보다
		 * 4. 근데 f[num] 에 2번에서 계산한걸 저장해두는거 아닌가?
		 * 5. 배열은 0부터 시작하니까, f[num-1] 의 값이 fib 의 횟수 아닐까?
		 * 6. 틀렸음.. 0이 들어오면 반드시 오류가 나는걸 발견 -> n 이 5 이상이라 전혀상관없음
		 * 7. n 이 20억이니까,, f[n] 에 저장되는 수는 훨씬 클것같은걸? -> 이것도 아니었음
		 * 8. 계산 결과를 배열에 저장해두는게 실패 원인인것같은데,, 그냥 계산만 해서 출력할 순 없을까?
		 * 9. for문 읽어보기
		 * num 이 5일때 : f[2] = f[1] + f[0] , f[3] = f[2] + f[1] , f[4] = f[3] + f[2] ,,,,
		 * f.length 는 num + 1, 5의 연산횟수를 구하려면 f[4] 를 출력해야했고, 총 연산횟수는 num - 2번?
		 * 그럼 저장안하고 구해보자
		 * 10. i 로 어떻게 해보려고 했는데, i-2 가 i-2 까지의 수열의 합을 담고있는게 아니라 곤란해짐
		 * 11. 기본 자료형은 어차피 메모리가 덮어씌워지니까, 기본 자료형에는 저장해도 되지 않을까?
		 * 12. temp1과 temp2를 만들어서 사용해보자
		 * 13. temp2에 i 를 저장하고 temp1 에 temp2+i 를 저장, answer에 temp1 을 누적했는데 값이 터무니없이 적게 나온다.
		 * 14. i 는 피보나치 수열의 숫자가 아니었음!
		 * 15. i는 그냥 연산횟수(배열에서 값의 위치)니까, temp1,temp2 에 피보나치 수열[0] [1] 을 저장해야 하는거였음
		 * 16. 피보나치 수열[0][1]은 1,1 이니까, temp 의 기본값을 1 로 만들어줌
		 * 17. temp1 의 값을 temp2 에 저장하고, P[0] + P[1] 을 temp1 에 저장하고, temp1 의 값을 answer 에 저장하자
		 * 18. 누적한 값을 answer 에 누적했더니 값이 이상하게 큼
		 * 19. temp 만 누적하고 answer 에는 누적이 아니었음
		 * 20. 값은 맞는데 또틀림
		 * 21. 1억9천을 넣어보니 answer 가 -3887445659537846981가 나옴???? => 93부터 음수
		 * 22. long 의 저장 범위를 넘어가서 음수로 바뀜
		 * 23. BigInteger 로 바꿔봤는데 얘도 시간초과 나옴. 얘도 참조 자료형이었음.. 8번으로 돌아옴
		 * 24. big 이 long 의 범위를 넘어갔을 때 1000000007 로 나누기엔 이미 늦어버림
		 *     big + small 했을 때 1000000007로 mod 연산을 하면 어떻게 되지?
		 * 25. small 이 3억, big 이 8억이라고 쳤을 때 %연산 적용하면 11억 - 10억7
		 *     남은 값은 answer,big 에 저장, small 이 8억
		 *     다음 연산에서 big 은 8억+, small 은 11억-10억7 ( 안넘음 )
		 *     다음은 17억쯤?, 8억+, % 해서 계산... 이게 맞나?
		 * */

		long answer = 0;
		long big = 1;
		long small = 1;

		for (long i = 0; i < num - 2; i++) { // bigTemp 의 값을 받아줄 임시 변수가 필요

			long temp = big;
			big += small;

			if (big > modTarget) {
				big %= modTarget;
			}

			small = temp;
			answer = big;
		}

		// f.length - 3 : 배열 만들때 + 1 한거, [0],[1] 의 값이 1이니까 둘 다 빼면 연산 횟수임
		// 그럼 그냥 num - 2 네?
		System.out.println(answer + " " + (num - 2));
	}
}