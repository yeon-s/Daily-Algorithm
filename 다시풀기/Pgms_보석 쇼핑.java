import java.util.*;

class Solution {
    static int min;
    static int[] answer;
    public int[] solution(String[] gems) {
        answer = new int[2];
        min = 1000000;
        
        Map<String,Integer> map = new HashMap<>();
        for(int i=0;i<gems.length;i++){
            map.put(gems[i],1);
        }
        
        int num = map.size();
        map.clear();
        
        int left= 0;
        int right=0;
        map.put(gems[0],1);
        
        while(right<gems.length){
            int cnt = map.size();
            
            if(cnt==num){       //모든 종류 담음
                check(left,right);
                int number = map.get(gems[left]);
                if(number<=1){
                    map.remove(gems[left]);   
                }else{
                    map.put(gems[left],number-1);
                }
                left++;
            }else{
                right++;
                if(right>=gems.length){
                    break;
                }
                map.put(gems[right],map.getOrDefault(gems[right],0)+1);
            }
        }
        
        return answer;
    }
    
    static void check(int left,int right){
        int diff = right-left;
        if(diff>=min){
            return;
        }else{
            answer[0]=left+1;
            answer[1]=right+1;
            min=diff;
        }
    }
}