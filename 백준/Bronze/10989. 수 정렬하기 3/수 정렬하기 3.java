import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int N = Integer.parseInt(br.readLine());
        int[] count = new int[10001];  // 숫자의 범위가 0부터 10,000까지이므로 10001 크기의 배열 사용

        // 입력받은 숫자의 개수를 count 배열에 저장
        for (int i = 0; i < N; i++) {
            int number = Integer.parseInt(br.readLine());
            count[number]++;
        }
        
        // count 배열을 순회하며 숫자들을 출력
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= 10000; i++) {
            while (count[i] > 0) {
                sb.append(i).append('\n');
                count[i]--;
            }
        }
        
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}