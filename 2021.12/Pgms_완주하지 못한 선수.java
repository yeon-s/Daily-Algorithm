import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        
        List<String> repetition = new ArrayList<>();
        HashSet<String> set = new HashSet<>();
        HashSet<String> set2 = new HashSet<>();
        List<String> repetition2 = new ArrayList<>();
        
        for(int i=0;i<completion.length;i++){
            if(set.contains(completion[i])){    //동명이인은
               repetition.add(completion[i]);        //리스트에 저장
            }
            set.add(completion[i]);
        }
        int size = set.size();
       
         for(int i=0;i<participant.length;i++){
            if(set2.contains(participant[i])){    //동명이인은
               repetition2.add(participant[i]);        //리스트에 저장
            }
            set2.add(participant[i]);
        }
        
        for(int i=0;i<participant.length;i++){
            set.add(participant[i]);
            if(size!=set.size()){
                answer = participant[i];
                break;
            }
        }
        if(answer.equals("")){
            for(int i=0;i<repetition.size();i++){
                if(repetition2.contains(repetition.get(i))){
                    repetition2.remove(repetition.get(i));
                }
            }
            answer = repetition2.get(0);
        }
            
        return answer;
    }
}