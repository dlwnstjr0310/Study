class Solution {
    public int[] solution(long n) {
        
        int index = 0;
        long num = n;
        
        while(num != 0){
            num /= 10;
            index++;
        }
        
        int[] answer = new int[index];
        
        index = 0;
        
        while(n > 0){
			answer[index] = (int) (n % 10);
			n = n / 10;
			index++;
		}
        
        return answer;
    }
}