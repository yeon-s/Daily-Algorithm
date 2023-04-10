import java.util.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        String[] answer = new String[players.length];
        
        Map<String,Integer> map = new HashMap<>();
        
        for(int i=0;i<players.length;i++){
            map.put(players[i],i);
        }
        
        for(int i=0;i<callings.length;i++){
            String call = callings[i];      //불린사람 이름
            
            int temp = map.get(call);  //불린 사람 현재 등수
            int front = temp-1;
            String frontP = players[front];   //앞에 있는 사람 이름
            
            players[front] = call;
            players[temp]= frontP;
            map.put(call,front);
            map.put(frontP,temp);
        }
        
        answer = players;
        return answer;
    }
    
}
