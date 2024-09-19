/*
 * 1. n 편의 논문 중 h번 이상 인용된 논문이 h편 이상이고, 나머지가 h번 이하 인용되었다면 h의 최댓값이 H-index
 * 2. 작은 값부터 찾아가야함. 0,1,3,5,6 이면 0, 1, 3 이 h 에 들어갈 수 있음. 5는 안된다 ㅜ
 * 3. 심지어 return 값이 3인게 배열의 3이 아니라, 3,5,6 이라서 총 3개라는 뜻이었음 ㅠ
 */

import java.util.*;

class Solution {
    public int solution(int[] citations) {
        
        int answer = 0;
        
		Arrays.sort(citations);

        for(int i = 0; i < citations.length; i++) {
            
            if(answer == 0 && citations[i] >= citations.length - i) {
                answer = citations.length - i;
            }
        }
        
		return answer;
    }
}