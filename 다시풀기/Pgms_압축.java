import java.util.*;

class Solution {
    public int[] solution(String msg) {
        int[] answer = {};
        
        List<Integer> list = new ArrayList<>();
        Map<String,Integer> map = new HashMap<>();
        //맵에 알파벳 넣어주자
        for(int i=1;i<=26;i++){
            char c = (char)(i+'A'-1);
            map.put(c+"",i);
        }
        
        int index=27;
        int size = msg.length();
        for(int i=0;i<size;i++){
            String str = msg.charAt(i)+"";
            int ans = map.get(str);
            int end = i+1;
            
            while(end<size){
                str+=msg.charAt(end)+"";
                if(map.containsKey(str)){
                    ans = map.get(str);
                }else{
                    map.put(str,index++);
                    break;
                }
                end++;
            }
            i=end-1;
            list.add(ans);
        }
        answer = new int[list.size()];
        for(int i=0;i<list.size();i++){
            answer[i] = list.get(i);
        }
        return answer;
    }
}