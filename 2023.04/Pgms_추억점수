import java.util.*;

class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        int[] answer = new int[photo.length];
        
        Map<String,Integer> map = new HashMap<>();
        
        for(int i=0;i<name.length;i++){
            map.put(name[i],yearning[i]);
        }
        
        for(int i=0;i<photo.length;i++){
            String[] arr = photo[i];
            int score = 0;
            
            for(int j=0;j<arr.length;j++){
                score+=map.getOrDefault(arr[j],0);
            }
            answer[i] = score;
        }
        return answer;
    }
}
