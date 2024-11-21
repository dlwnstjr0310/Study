import java.util.*;

class Solution {
    public long solution(long n) {
        
        String convert = String.valueOf(n);
        String[] split = convert.split("");
        
		Arrays.sort(split, Collections.reverseOrder());

		StringBuilder sb = new StringBuilder();

		for (String str : split) {
			sb.append(str);
		}
        
        return Long.parseLong(sb.toString());
    }
}