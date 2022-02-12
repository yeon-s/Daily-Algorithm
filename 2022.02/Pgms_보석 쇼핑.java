import java.util.*;

class Solution {
    public int[] solution(String[] gems) {
        int[] answer = new int[2];
        
        Map<String,Integer> map = new HashMap<>();
        
        for(int i=0;i<gems.length;i++){
            map.put(gems[i],map.getOrDefault(gems[i],0)+1);
        }
        
        int sortNum = map.size();
        
        PriorityQueue<store> pq = new PriorityQueue<>();
        
        int start=0;
        int end=0;
        map.clear();
        map.put(gems[0],1);
        
        while(end<gems.length){
            if(map.size()<sortNum){
                end++;
                if(end>=gems.length){
                    break;
                }
                map.put(gems[end],map.getOrDefault(gems[end],0)+1);
            }else{
                pq.offer(new store(start,end));
                int num = map.get(gems[start]);
                if(num==1){
                    map.remove(gems[start]);
                }else{
                    map.put(gems[start],num-1);
                }
                start++;
            }
        }
        
        store s = pq.poll();
        answer[0]=s.start+1;
        answer[1]=s.end+1;
        
        return answer;
    }
    
    static class store implements Comparable<store>{
        int start;
        int end;
        public store(int start,int end){
            this.start=start;
            this.end=end;
        }
        
        public int compareTo(store o){
            int o1 = this.end-this.start;
            int o2 = o.end-o.start;
            if(o1==o2){
                return this.start-o.start;
            }
            return o1-o2;
        }
    }
}