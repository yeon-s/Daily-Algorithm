import java.util.*;

class Solution {
    public int[] solution(String msg) {
        int[] answer;
        int size = msg.length();
        List<Integer> list = new ArrayList<>();
        int index=27;
        
        Map<String,Integer> map = new HashMap<>();
        for(int i=0;i<26;i++){
            char c = (char)('A'+i);
            map.put(c+"",i+1);
        }
        
        for(int i=0;i<size;i++){
            String str = msg.charAt(i)+"";
            int num = map.get(str);
            int next = i+1;
            
            while(next<size){
                String nextStr = msg.charAt(next)+"";
                str+=nextStr;
                if(map.containsKey(str)){
                    num=map.get(str); 
                    next++;
                }else{
                    map.put(str,index++);
                    break;
                }    
            }
            list.add(num);
            i=next-1;
        }
        
        answer = new int[list.size()];
        for(int i=0;i<list.size();i++){
            answer[i]=list.get(i);
        }
        return answer;
    }
}