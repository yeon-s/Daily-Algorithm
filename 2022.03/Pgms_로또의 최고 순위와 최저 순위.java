import java.util.*;

class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        
        Map<Integer,Integer> win = new HashMap<>();
        for(int i=0;i<6;i++){
            win.put(win_nums[i],0);
        }
        
        int cnt=0;
        int max=0;
        for(int i=0;i<6;i++){
            if(lottos[i]==0){
                max++;
            }else{
                if(win.containsKey(lottos[i])){
                    cnt++;
                }
            }
        }
        max+=cnt;
        if(cnt==0){
            answer[1]=6;
        }else{
            answer[1]=7-cnt;
        }
        if(max==0){
            answer[0]=6;
        }else{
            answer[0]=7-max;
        }
        
        return answer;
    }
}