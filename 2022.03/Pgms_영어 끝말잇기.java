import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];

        int tern =1;
        int cnt=1;
        Map<String,Integer> map = new HashMap<>();
        int size = words.length;
        boolean flag = false;
        
        for(int i=0;i<size;i++){
            if(i>=1){
                if(words[i-1].charAt(words[i-1].length()-1)!=words[i].charAt(0)){
                    flag=true;
                    break;
                }
            }
            if(map.containsKey(words[i])){
                flag=true;
                break;
            }
            tern++;
            map.put(words[i],0);
            if(tern>n){
                tern=1;
                cnt++;
            }
        }

        if(flag){
            answer[0]=tern;
            answer[1]=cnt;
        }else{
            answer[0]=0;
            answer[1]=0;
        }
        return answer;
    }
}