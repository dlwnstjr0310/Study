import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static Integer[][] map = new Integer[9][9];
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int i = 0; i < 9; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 9; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		findNumber(0, 0);

	}

	private static void findNumber(int rowCount, int columnCount) {

		/*
		 * 백트래킹 : 모든 경우의 수를 탐색, 가능성이 없는경우 탐색 중단
		 * -> 가로/세로/3x3 블록에 0이 없는경우
		 * 1. 가로 : x + 1 / 세로 : y + 1 / 3x3 : x+3, x==6 -> x=0,y+3 -> x+3, x==6 -> x=0,y+3
		 * 2. 시간이 1초니까, 빨리 해야할것같음
		 * 3. Set 의 contains 가 시간복잡도가 O(1) 이니까, Set 으로 사용하자
		 * 4. Set 은 순서가 지멋대로라 못쓴다
		 * 5. 억지로 예제에는 맞게 만들었는데, 2칸씩 비어있을 경우에는 작동을 안함
		 * 6. 너무.. 지쳐서 구글링
		 * */
		if (columnCount == 9) {
			findNumber(rowCount + 1, 0);
			return;
		}

		if (rowCount == 9) {
			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					sb.append(map[i][j]).append(' ');
				}
				sb.append('\n');
			}
			System.out.print(sb);
			System.exit(0);
		}

		if (map[rowCount][columnCount] == 0) {
			for (int i = 1; i <= 9; i++) {
				if (valid(rowCount, columnCount, i)) {
					map[rowCount][columnCount] = i;
					findNumber(rowCount, columnCount + 1);
				}
			}
			map[rowCount][columnCount] = 0;
			return;
		}

		findNumber(rowCount, columnCount + 1);
	}

	private static boolean valid(int row, int column, int value) {

		List<Integer> rowList = Arrays.asList(map[row]);

		for (int i = 0; i < 9; i++) {
			if (rowList.get(i) == value) {
				return false;
			}
		}

		List<Integer> columnList = getColumnList(column);

		for (int i = 0; i < 9; i++) {
			if (columnList.get(i) == value) {
				return false;
			}
		}

		int[][] range = getRange(row, column);

		for (int i = range[0][0]; i < range[0][1]; i++) {
			for (int j = range[1][0]; j < range[1][1]; j++) {
				if (map[i][j] == value) {
					return false;
				}
			}
		}

		return true;
	}

	private static List<Integer> getColumnList(int column) {
		List<Integer> columnList = new ArrayList<>();

		for (int i = 0; i < 9; i++) {
			columnList.add(map[i][column]);
		}

		return columnList;
	}

	private static int[][] getRange(int row, int column) {
		/* 0일때 : 00 ~ 22
		 * 1일때 : 03 ~ 25
		 * 2일때 : 06 ~ 28
		 * 3일때 : 30 ~ 52
		 * 4일때 : 33 ~ 55
		 * 5일때 : 36 ~ 58
		 * 6일때 : 60 ~ 82
		 * 7일때 : 63 ~ 85
		 * 8일때 : 66 ~ 88*/
		int startRow = (row / 3) * 3; // box < 3 : 0 , 3 < box < 6 : 3, 6 < box : 6
		int startCol = (column / 3) * 3; // box = 0,3,6 : 0, box = 1,4,7 : 3, box = 2,5,8 : 6
		int endRow = startRow + 3;
		int endCol = startCol + 3;

		return new int[][]{{startRow, endRow}, {startCol, endCol}};
	}
}