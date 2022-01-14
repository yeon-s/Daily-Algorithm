import java.util.*;

class Solution {
    static int N;
    static int M;
    static String[] result;
    static boolean[] isSelected;
    static int answer;
    static Set<String> set;
    public int solution(String[] user_id, String[] banned_id) {
        answer = 0;
      
        N = user_id.length;
        M = banned_id.length;
        result = new String[M];
        isSelected = new boolean[N];
        set = new HashSet<>();
        
        perm(0,user_id,banned_id);
        for(String str:set){
            System.out.println(str);
        }
        
        return answer;
    }
    
    static void perm(int cnt,String[] user_id, String[] banned_id){
        if(cnt==M){
            String[] copy = new String[M];
            for(int i=0;i<M;i++){
               copy[i]=result[i];
            }
            
            Arrays.sort(copy);
            
            StringBuilder sb = new StringBuilder();
            for(String str:copy){
                sb.append(str);
            }
            
            if(!set.contains(sb+"")){
                answer++;
                set.add(sb+"");
            }
            
            return;
        }
        
        for(int i=0;i<N;i++){
            if(isSelected[i]){
                continue;
            }
            if(check(banned_id[cnt],user_id[i])){
                isSelected[i]=true;
                result[cnt]=user_id[i];
                perm(cnt+1,user_id,banned_id);
                isSelected[i]=false;
            }    
            
        }
        
    }
    
    static boolean check(String ban, String id){
        if(ban.length() != id.length()){
            return false;
        }
        
        for(int i=0;i<id.length();i++){
            if(ban.charAt(i)=='*'){
                continue;
            }
            
            if(ban.charAt(i) != id.charAt(i)){
                return false;
            }
        }
        
        return true;
    }
}