import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        
        LinkedList<String> list = new LinkedList<>();
        
        int size = cities.length;
        for(int i=0;i<size;i++){
            String city = cities[i];
            city=city.toLowerCase();
            
            if(list.contains(city)){
                answer++;
                list.remove(city);
            }else{
                answer+=5;
            }
            
            list.addFirst(city);
            if(list.size()>cacheSize){
                list.remove(list.size()-1);
            }
            
        }
        return answer;
    }
}