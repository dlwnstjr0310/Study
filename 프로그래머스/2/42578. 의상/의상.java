import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        
        int answer = 1;
        
        // 조합에서 종류가 n 개면 (n1+1) * (n2+1) * (n3+1) 이 조합의 수, 알몸 제외 -1
        
        Map<String,Integer> clothesMap = new HashMap<>();
        
        for(int i = 0; i < clothes.length; i++) {

            clothesMap.put(clothes[i][1], clothesMap.getOrDefault(clothes[i][1], 0) + 1);
        }
        
        Set<Map.Entry<String, Integer>> entrySet = clothesMap.entrySet();
        
        for (Map.Entry<String, Integer> entry : entrySet) {
			
            answer *= entry.getValue() + 1;
		}

        
        return answer - 1;
    }
}