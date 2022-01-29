import java.util.*;

class Solution {
    static boolean flag=false;
    static int size;
    static Map<String,Integer> map;
    static String[][] ticket;
    static String[] answer;
    public String[] solution(String[][] tickets) {
        size = tickets.length;
        answer = new String[size+1];
        map = new HashMap<>();
        
        for(int i=0;i<size;i++){
            String str= tickets[i][0]+tickets[i][1];
            map.put(str, map.getOrDefault(str,0)+1);
        }
        
        ticket=tickets;
        Arrays.sort(ticket, new Comparator<String[]>(){
           public int compare(String[] o1,String[] o2){
               if(o1[0].equals(o2[0])){
                   return o1[1].compareTo(o2[1]);
               }else{
                   return o1[0].compareTo(o2[0]);
               }
           } 
        });
        
        dfs("ICN",0);
        
        return answer;
    }
    
    static void dfs(String current,int cnt){
        if(flag){
            return;
        }
        answer[cnt]=current;
        
        if(cnt==size){
            flag=true;
            return;
        }
        
        for(int i=0;i<size;i++){
            if(ticket[i][0].equals(current)){
                String str = ticket[i][0]+ticket[i][1];
                if(map.get(str)>=1){
                    
                    map.put(str,map.get(str)-1);
                    dfs(ticket[i][1],cnt+1);
                    map.put(str,map.get(str)+1);
                }
            }
        }
    }
}