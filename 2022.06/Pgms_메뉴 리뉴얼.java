import java.util.*;

class Solution {
    static String menu;
    static Map<String,Integer> map;
    static String result;
    public String[] solution(String[] orders, int[] course) {
        String[] answer;
        List<String> list = new ArrayList<>();
        
        map = new HashMap<>();
        //손님들 주문들 돌면서 부분집합
        for(int i=0;i<orders.length;i++){
            menu = orders[i];
            char[] arr = menu.toCharArray();
            Arrays.sort(arr);
            menu = new String(arr);
            
            System.out.println();
            result = "";
            subset(0);
        }
        
        for(int i=0;i<course.length;i++){
            int num = course[i];
            int max=0;
            //가장 많이 주문된 코스 찾기
            for(String str:map.keySet()){
                if(str.length()==num){
                    max = Math.max(max,map.get(str));
                }
            }
            
            for(String str:map.keySet()){
                if(str.length()==num && max>1 && map.get(str)==max){
                    list.add(str);
                }
            }
            
        }
        
        answer = new String[list.size()];
        Collections.sort(list);
        for(int i=0;i<list.size();i++){
            answer[i]=list.get(i);
        }
        
        return answer;
    }
    
    static void subset(int target){
        if(target==menu.length()){
            if(result.length()>1){
                map.put(result,map.getOrDefault(result,0)+1);
            }
            return;
        }
        result+=menu.charAt(target)+"";
        subset(target+1);
        result=result.substring(0,result.length()-1);
        subset(target+1);
    }
}