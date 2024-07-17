import java.io.*;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		StringBuilder sb = new StringBuilder();

		int melon = Integer.parseInt(st.nextToken());

		int[][] arr = new int[6][2];

		int heightIndex = 0;
		int widthIndex = 0;
		int maxHeight = 0;
		int maxWidth = 0;

		for (int i = 0; i < 6; i++) {

			st = new StringTokenizer(bf.readLine());

			for (int j = 0; j < 2; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());

				if (j == 1 && (arr[i][0] == 1 || arr[i][0] == 2)) {
					if (maxWidth < arr[i][j]) {
						maxWidth = arr[i][j];
						widthIndex = i;
					}
				} else {
					if (j == 1 && maxHeight < arr[i][j]) {
						maxHeight = arr[i][j];
						heightIndex = i;
					}
				}
			}
		}


		// 왼쪽 면 : 3 , 아래 면 : 1 , 오른쪽 면 : 4 , 윗 면 : 2
		// 순서는 반드시 3 -> 1 -> 4 -> 2 임 ( 반시계 )
		// 총 길이가 먼저 나오는 쪽의 반대가 비어있음 => maxHeight,maxWidth 랑 안이어진곳 구하기
		// => max 값 다음이 세로 (3,4) 면 높이는 maxHeight - 연결된 첫 세로값 / 길이는 첫 세로값 바로 다음
		// => 가로 (1,2) 면 길이는 maxWidth - 연결된 첫 가로값 / 높이는 첫 가로값 바로 다음

		int x = arr[(widthIndex + 3) % 6][1];
		int y = arr[(heightIndex + 3) % 6][1];

		System.out.println(((maxHeight * maxWidth) - (x * y)) * melon);

	}
}