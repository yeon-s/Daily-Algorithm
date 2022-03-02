import java.util.*;

class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        
        Map<Character,Integer> map = new HashMap<>();
        char[] arr = skill.toCharArray();
        for(int i=0;i<arr.length;i++){
            map.put(arr[i],i);
        }
        
        for(int i=0;i<skill_trees.length;i++){
            String str = skill_trees[i];
            
            int index=0;
            boolean flag=true;
            for(int j=0;j<str.length();j++){
                char c = str.charAt(j);
                if(map.containsKey(c)){
                    if(map.get(c)==index){
                        index++;
                    }else{
                        flag=false;
                        break;
                    }
                }
            }
            if(flag){
                answer++;
            }
        }
        return answer;
    }
}