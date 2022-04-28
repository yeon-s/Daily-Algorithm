import java.util.*;

class Solution {
    
    static int num;
    static Map<String,Integer> map;
    static String com;
    static String result;
    public List<String> solution(String[] orders, int[] course) {
        List<String> answer = new ArrayList<>();
        
        for(int i=0;i<course.length;i++){
            num = course[i];
            map = new HashMap<>();
            
            for(int j=0;j<orders.length;j++){
                com = orders[j];
                result="";
                comb(0,0);
            }
            PriorityQueue<Combi> pq = new PriorityQueue<>();
            for(String str:map.keySet()){
                int cnt = map.get(str);
                
                if(cnt>=2){
                    pq.offer(new Combi(str,cnt));
                }
            }
            int max=0;
            if(!pq.isEmpty()){
                Combi c = pq.poll();
                max=c.cnt;
                answer.add(c.str);
            }
            while(!pq.isEmpty()){
                Combi c = pq.poll();
                if(c.cnt==max){
                    answer.add(c.str);
                }else{
                    break;
                }
            }
        }
        Collections.sort(answer);
        return answer;
    }
    
    static class Combi implements Comparable<Combi>{
        String str;
        int cnt;
        public Combi(String str,int cnt){
            this.str=str;
            this.cnt=cnt;
        }
        public int compareTo(Combi o){
            return o.cnt-this.cnt;
        }
    }
    
    static void comb(int cnt,int start){
        if(cnt==num){
            char[] arr = result.toCharArray();
            Arrays.sort(arr);
            String temp = "";
            for(char c:arr){
                temp+=c+"";
            }
            map.put(temp,map.getOrDefault(temp,0)+1);
            return;
        }
        
        for(int i=start;i<com.length();i++){
            result+=com.charAt(i)+"";
            comb(cnt+1,i+1);
            result= result.substring(0,result.length()-1);
        }
    }
}