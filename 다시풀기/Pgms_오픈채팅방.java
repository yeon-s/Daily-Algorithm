import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        String[] answer = {};
        
        Map<String,String> map = new HashMap<>();
        List<Boolean> enterOrExit = new ArrayList<>();  //true면 입장 false면 퇴장
        List<String> id = new ArrayList<>();        //유저 아이디 저장
        
        for(int i=0;i<record.length;i++){
            String[] arr = record[i].split(" ",-1);
            String what = arr[0];
            if(what.equals("Enter")){
                map.put(arr[1],arr[2]);
                id.add(arr[1]);
                enterOrExit.add(true);
            }else if(what.equals("Leave")){
                id.add(arr[1]);
                enterOrExit.add(false);
            }else if(what.equals("Change")){
                map.put(arr[1],arr[2]);
            }
        }
        
        answer = new String[id.size()];
        StringBuilder sb;
        for(int i=0;i<id.size();i++){
            sb= new StringBuilder();
            sb.append(map.get(id.get(i))+"").append("님이 ");
            if(enterOrExit.get(i)){
                sb.append("들어왔습니다.");
            }else{
                sb.append("나갔습니다.");
            }
            answer[i] = sb+"";
        }
        return answer;
    }
}