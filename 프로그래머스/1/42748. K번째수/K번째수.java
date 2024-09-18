/*
 * 1. array 를 command 로 자르기. 첫번째가 시작, 두번째가 마무리, 세번째가 위치
 * 2. 시작 ~ 마무리까지 자르고, 정렬한 후 위치의 값 answer 에 입력 (정렬 안함)
 * 
 */

import java.util.*;


class Solution {
    public int[] solution(int[] array, int[][] commands) {
        
        int[] answer = new int[commands.length];
        
        for(int i = 0 ; i < commands.length ; i++){
            
            int start = commands[i][0] - 1;
            int end = commands[i][1] - 1;
            int point = commands[i][2] - 1;
            
            int[] copy = new int[end - start + 1];
            int index = 0;
            
            for(int j = start; j <= end; j++) {
                copy[index++] = array[j];
            }
            
            Arrays.sort(copy);
            
            answer[i] = copy[point];
        }
        
        return answer;
    }
}