import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        
        Map<String,Integer> userIndex = new HashMap<>();
        for(int i=0;i<id_list.length;i++){
            userIndex.put(id_list[i],i);
        }
        
        Map<String, Integer> reportMap = new HashMap<>();
        for(int i=0;i<report.length;i++){
            reportMap.put(report[i],0);
        }
        
        Map<String,Integer> reportCountMap = new HashMap<>();
        for(String s:reportMap.keySet()){
            StringTokenizer st = new StringTokenizer(s);
            String user = st.nextToken();
            String reportUser = st.nextToken();
            reportCountMap.put(reportUser,reportCountMap.getOrDefault(reportUser,0)+1);
        }
        
        List<String> reportList = new ArrayList<>();
        for(String s:reportCountMap.keySet()){
            if(reportCountMap.get(s)>=k){
                reportList.add(s);
            }
        }
        
        for(String s:reportMap.keySet()){
            StringTokenizer st = new StringTokenizer(s);
            String user = st.nextToken();
            String reportUser = st.nextToken();
            if(reportList.contains(reportUser)){
                answer[userIndex.get(user)]++;
            }
            reportCountMap.put(reportUser,reportCountMap.getOrDefault(reportUser,0)+1);
        }
        
        
        return answer;
    }
}