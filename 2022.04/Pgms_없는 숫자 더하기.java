import java.util.*;

class Solution {
    public int solution(int[] numbers) {
        int answer = 45;
        
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<numbers.length;i++){
            map.put(numbers[i],0);
        }
        
        int num=0;
        for(int i:map.keySet()){
            num+=i;
        }
        return answer-num;
    }
}