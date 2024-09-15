
/*
 * 입력 : 선수 명단 participant, 완주 명단 completion
 * 
 * 기능 : 완주하지 못한 선수 명단 만들기
 * 1. 아마.. participant 저장하고.. completion 제거하면 될듯..?
 * 2. set 에는 중복값이 저장 불가. 동명이인 있음 ㅠ
 * 3. map 으로 써야할것같은데,, value 가 null 인게 거슬리네
 * 4. list 로..!
 * 5. list 시간초과 나옴 ㅠ hash~ 사용해서.. 동명이인 있으면 카운트같은거 만들어서 사용해야할듯?
 * 6. 동명이인이 몇명 있는지 모르니까.. LinkedList 사용하면,,?
 * 7. linkedList 도 시간초과가 나옴; O(1) 인데.. 뭐가 문제일까?
 * 8. 그냥 그럼.. map으로 동명이인 카운트까지 만들어서 해보자
 * 9. 그냥.. 배열 정렬해서 봐도 될듯
 * 출력 : 완주하지 못한 선수 리턴
 */

import java.util.*;


class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        
        Arrays.sort(participant);
        Arrays.sort(completion);
        
        boolean isComplete = false;
        
        for(int i = 0; i < completion.length; i++) {
            if(!participant[i].equals(completion[i])) {
                answer = participant[i];
                isComplete = true;
                break;
            }
        }
        
        if(!isComplete)
            answer = participant[participant.length - 1];
                
        return answer;
    }
}