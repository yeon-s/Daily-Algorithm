import java.util.*;

class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        
        int zeroCnt =0;
        Map<Integer,Integer> map = new HashMap<>();
        
        for(int i=0;i<6;i++){
            if(lottos[i]==0){
                zeroCnt++;
            }
            map.put(win_nums[i],1);
        }
        
        int cnt=0;      //일치 개수
        for(int i=0;i<6;i++){
            if(map.containsKey(lottos[i])) cnt++;
        }
        
        answer[0]=7-(cnt+zeroCnt);
        answer[1]=7-cnt;
        if(answer[0]>6) answer[0]=6;
        if(answer[1]>6) answer[1]=6;
        return answer;
    }
}