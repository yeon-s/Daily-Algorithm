import java.util.*;

class Solution {
    static int size;
    static int[] result;
    static int[] Numbers;
    static List<Integer> list;
    public int[] solution(int[] numbers) {
        int[] answer;
        
        size = numbers.length;
        result = new int[2];
        Numbers = numbers;
        list = new ArrayList<>();
        
        comb(0,0);
        
        Collections.sort(list);
        int listSize = list.size();
        answer = new int[listSize];
        
        for(int i=0;i<listSize;i++){
            answer[i] = list.get(i);
        }
        return answer;
    }
    
    static void comb(int cnt, int start){
        if(cnt==2){
            int num = result[0]+result[1];
            if(!list.contains(num)){
                list.add(num);
            }
            return;
        }
        
        for(int i=start;i<size;i++){
            result[cnt]=Numbers[i];
            comb(cnt+1,i+1);
        }
    }
}