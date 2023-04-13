import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        
        Map<String, Integer> map = new HashMap<>();     //누가 누구 신고했는지(중복없이)
        Map<String, Integer> map2 = new HashMap<>();    //신고 몇번 당했는지
        Map<String, Integer> map3 = new HashMap<>();    //id_list 인덱스
        
        for(int i=0;i<id_list.length;i++){
            map3.put(id_list[i],i);
        }
        
        for(int i=0;i<report.length;i++){
            String str = report[i];
            String[] arr = report[i].split(" ");
            
            if(!map.containsKey(str)){
                map.put(str,0);
                map2.put(arr[1],map2.getOrDefault(arr[1],0)+1);
            }
            
        }
        
        for(String str:map.keySet()){
            String[] arr = str.split(" ");
            
            int cnt = map2.get(arr[1]);     //신고당한횟수
            if(cnt>=k) answer[map3.get(arr[0])]++;
        }
        return answer;
    }
}
