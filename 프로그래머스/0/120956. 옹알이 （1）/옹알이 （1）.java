class Solution {
    public int solution(String[] babbling) {
        
        int result = 0;
        String[] words = {"aya", "ye", "woo", "ma"};
        
        for(String target : babbling) {
            
            String str = target;
            
            // aya ye woo ma 반복
            for(int i = 0 ; i < words.length ; i++) {
                
                if(str.contains(words[i])) {
                    str = str.replace(words[i], " ");
                    
                    if(str.trim().isEmpty()) {
                        result++;
                    } else {
                        i = 0;
                    }
                }
            }
        }
        return result;
    }
}