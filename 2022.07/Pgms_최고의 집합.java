import java.util.*;

class Solution {
    public int[] solution(int n, int s) {
        
        
        int moc = s/n;
        int nam = s%n;
        if(moc==0){
            int[] answer = new int[1];
            answer[0]=-1;
            return answer;
        }
        
        int[] answer = new int[n];
        Arrays.fill(answer,moc);
        for(int i=0;i<nam;i++){
            answer[n-1-i]+=1;
        }
        
        return answer;
    }
}