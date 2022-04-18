package com.codingtest;

import java.util.Arrays;

public class Solution {
	
	public int[] solution(int[] lottos, int[] win_nums) {
        int count = 0;
        int zero_cnt = 0;
        
        for(int i = 0; i<lottos.length; i++){
            for(int j = 0; j<win_nums.length; j++){
                if(lottos[i] == win_nums[j]){
                    count += 1;
                } 
            }
        }
        
        for(int i = 0; i<lottos.length; i++) {
        	if(lottos[i]==0) {
        		zero_cnt += 1;
        	}
        }
        
        int[] answer = new int[2];
        
        if(count == 6) {
        	answer[0] = 1;
        	answer[1] = 1;
        } else if(count == 5) {
        	answer[0] = 1-(zero_cnt-1);
        	answer[1] = 2;
        } else if(count == 4) {
        	answer[0] = 1-(zero_cnt-2);
        	answer[1] = 3;
        } else if(count == 3) {
        	answer[0] = 2-(zero_cnt-2);
        	answer[1] = 4;
        } else if(count == 2) {
        	answer[0] = 3-(zero_cnt-2);
        	answer[1] = 5;
        } else if(count == 1) {
        	answer[0] = 4-(zero_cnt-2);
        	answer[1] = 6;
        } else {
        	answer[0] = 5-(zero_cnt-2);
        	answer[1] = 6;
        }
        if(answer[0] == 7) {
        	answer[0] = 6;
        }
        
        return answer;
    }
	
	public static void main(String[] args) {
        int[] lottos = {30,2,5,7,17,18};
        int[] win_nums = {31,10,45,1,6,19};

        Solution s = new Solution();
        System.out.println(Arrays.toString(s.solution(lottos, win_nums)));
	}

}
