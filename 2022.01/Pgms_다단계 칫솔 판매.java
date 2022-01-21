import java.util.*;

class Solution {
    static int[] answer;
    static int[] parent;
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        answer = new int[enroll.length];
        parent = new int[referral.length];    //부모의 인덱스 저장할 배열
        
        Map<String,Integer> map = new HashMap<>();
        
        for(int i=0;i<enroll.length;i++){
            map.put(enroll[i],i);
        }
        
        for(int i=0;i<referral.length;i++){
            if(referral[i].equals("-")){
                parent[i]=-1;
            }else{
                int num = map.get(referral[i]);
                parent[i]=num;
            }
        }
        
        for(int i=0;i<seller.length;i++){
            String who = seller[i];
            int money = amount[i]*100;
            
            int index = map.get(who);
            
            dfs(index,money);
            
        }
        
        return answer;
    }
    
    static void dfs(int index,int money){
        if(index==-1){
            return;
        }
        if(money/10>=1){
            answer[index]+= money-(money/10);
            money=money/10;
            int parents = parent[index];
            dfs(parents,money);
        }else{
            answer[index]+=money;
        }
    }
}