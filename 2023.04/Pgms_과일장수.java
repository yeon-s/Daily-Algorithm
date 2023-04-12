import java.util.*;

class Solution {
    public int solution(int k, int m, int[] score) {
        int answer = 0;
        int size = score.length;
        
        int nam = size%m;
        int i=nam;
        Arrays.sort(score);
        
        while(i<size){
            
            answer+= score[i]*m;
            
            i+=m;
        }
        return answer;
    }
}
