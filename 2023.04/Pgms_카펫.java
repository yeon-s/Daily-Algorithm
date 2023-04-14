import java.util.*;

class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        
        int sum = brown+yellow;
        
        // x+y = (brown+4)/2;
        // x*y = sum;
        // yellow = (x-2)*(y-2);
        
        for(int i=1;i<=2000000;i++){
            int j = sum/i;
            if(sum%i!=0) continue;
            if(i+j==(brown+4)/2 && (i-2)*(j-2)==yellow){
                answer[0] = i;
                answer[1] = j;
            }
        }
        return answer;
    }
}
