import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        
        int[] first = {1,2,3,4,5};
        int[] second = {2,1,2,3,2,4,2,5};
        int[] third = {3,3,1,1,2,2,4,4,5,5};
        int[] score = {0,0,0};
        
        for(int i = 0; i < answers.length; i++) {
            
            int firstIndex = i % first.length;
            int secondIndex = i % second.length;
            int thirdIndex = i % third.length;
                        
            if(answers[i] == first[firstIndex])
                score[0]++;
            if(answers[i] == second[secondIndex])
                score[1]++;
            if(answers[i] == third[thirdIndex])
                score[2]++;
            
        }
        
        int max = Math.max(score[0], Math.max(score[1], score[2]));
		int count = 0;
        int[] index = {0,0,0};
		
		for (int i = 0; i < score.length; i++) {
			if (max == score[i]) {
				count++;
                index[i] = i;
			}
		}
		
		int[] answer = new int[count];
        int temp = 0;
        
        for(int i = 0; i < score.length; i++) {
            if(max == score[i]) {
                answer[temp++] = i + 1;
            }
        }
        
        return answer;
    }
}