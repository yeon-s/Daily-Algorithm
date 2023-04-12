import java.util.*;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        int[] answer = {};
        List<Integer> list = new ArrayList<>();
        
        Map<String,Integer> map = new HashMap<>();  
        
        for(int i=0;i<terms.length;i++){
            String[] arr = terms[i].split(" ");
            
            map.put(arr[0],Integer.parseInt(arr[1]));
        }
        
        for(int i=0;i<privacies.length;i++){
            String[] arr = privacies[i].split(" ");
            
            int mazino = cal(arr[0],map.get(arr[1]));
            
            if(!compare(today,mazino)){
                list.add(i+1);
            }
        }
        
        answer = new int[list.size()];
        for(int i=0;i<list.size();i++){
            answer[i] = list.get(i);
        }
        return answer;
    }
    
    static int cal(String date, int kind){
        String[] arr = date.split("\\.");
        
        int y = Integer.parseInt(arr[0]);
        int m = Integer.parseInt(arr[1]);
        int d = Integer.parseInt(arr[2]);
        
        int num = y*12*28;
        num+= (m+kind)*28+d;
        
        return num;
    }
    
    static boolean compare(String today, int mazino){
        
        int todayNum = cal(today,0);
        if(todayNum<=mazino-1) return true;
        return false;
    }
}
