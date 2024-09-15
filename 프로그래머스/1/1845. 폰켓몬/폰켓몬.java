
/*
 * 입력 / 기능 / 출력
 * 1. [3,1,2,3] 형식의 배열 입력, size 는 항상 짝수
 * 2. size/2 만큼 골라서 종류가 가장 많은 경우 체크
 * 2-1. 이거.. nums 안에 다른 값이 몇개 있는지 체크하고, size/2보다 크면 size/2 리턴, 작으면 다른 값만큼?
 * 3. 종류 번호의 갯수 리턴
 */

import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        
        int result = nums.length / 2;
        
        Set<Integer> set = new HashSet<>();
        
        for(int num : nums) {
            set.add(num);
        }
        
        if(set.size() >= result) {
            answer = result;
        } else {
            answer = set.size();
        }
        
        return answer;
    }
}