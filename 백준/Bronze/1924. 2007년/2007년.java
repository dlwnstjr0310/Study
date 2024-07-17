import java.io.*;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());

		int month = Integer.parseInt(st.nextToken());
		int day = Integer.parseInt(st.nextToken());

		LocalDate localDate = LocalDate.of(2007, month, day);
		DayOfWeek dayOfWeek = localDate.getDayOfWeek();

		System.out.println(dayOfWeek.toString().substring(0, 3));
	}
}