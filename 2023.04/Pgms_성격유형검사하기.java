import java.util.*;

class Solution {
    public String solution(String[] survey, int[] choices) {
        String answer = "";
        int size = survey.length;
        String[] arr = {"RT","CF","JM","AN"};
        
        Map<Character,Integer> map = new HashMap<>();
        
        for(int i=0;i<size;i++){
            int score = choices[i]-4;
            
            if(score<0){        //비동의이므로 앞의 성격유형
                char c = survey[i].charAt(0);
                map.put(c,map.getOrDefault(c,0)+Math.abs(score));
            }else if(score>0){
                char c = survey[i].charAt(1);
                map.put(c,map.getOrDefault(c,0)+Math.abs(score));
            }
            
        }
        
        for(int i=0;i<4;i++){
            String str = arr[i];
            
            char c1 = str.charAt(0);
            char c2 = str.charAt(1);
            
            String choice = "";
            if(map.getOrDefault(c1,0)>=map.getOrDefault(c2,0)){
                choice = c1+"";
            } else{
                choice = c2+"";
            }
            
            answer+=choice;
        }
        
        return answer;
    }
}
