import java.util.*;

class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];
        
        Map<Character,Integer> map = new HashMap<>();   //문자마다 최소 횟수 저장할 맵
        
        for(String str: keymap){
            for(int i=0;i<str.length();i++){
                char c = str.charAt(i);
                if(map.containsKey(c) && i+1>=map.get(c)) continue;
                map.put(c,i+1);
            }
        }
        
        for(int j=0;j<targets.length;j++){
            String str = targets[j];
            boolean flag = true;
            int sum = 0;
            for(int i=0;i<str.length();i++){
                char c = str.charAt(i);
                
                if(!map.containsKey(c)){
                    flag = false;
                    break;
                } 
                sum+=map.get(c);
            }
            answer[j] = sum;
            if(!flag) answer[j] = -1;
            
        }
        
        return answer;
    }
}
