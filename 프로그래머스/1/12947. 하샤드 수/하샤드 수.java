class Solution {
    public boolean solution(int x) {
        
        String[] arr = String.valueOf(x).split("");
        
        int answer = 0;
        
        for(String s : arr) {
            answer += Integer.valueOf(s);
        }
        
        if(x % answer == 0) {
            return true;
        } else {
            return false;
        }
    }
}