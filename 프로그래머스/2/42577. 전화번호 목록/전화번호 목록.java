import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        
        Arrays.sort(phone_book);
        
        for(int i = 0 ; i < phone_book.length - 1 ; i++) {
            
            // 이중for문 쓸 필요 없이 정렬하면 ㄱㅊ
            if(phone_book[i + 1].startsWith(phone_book[i]))
                answer = false;
        }
        
        return answer;
    }
}