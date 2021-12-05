import java.util.*;

class Solution {
    public List<Integer> solution(String msg) {
        List<Integer> answer = new ArrayList<>();
        
        List<String> list = new ArrayList<>();
        String str = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        list.add("0");
        for(int i=0;i<str.length();i++){
            list.add(str.charAt(i)+"");
        }
        
        for(int i=0;i<msg.length();i++){
            String current = msg.charAt(i)+"";
            int num=1;
            String temp=msg.charAt(i)+"";
            if(i==msg.length()-1){
                answer.add(list.indexOf(temp));
                break;
            }
            boolean flag = false;
            while(true){
                String next = (msg.charAt(i+num)+"");
               temp += next;
                //temp += msg.charAt(i+num)+"";
                if(list.contains(temp)){
                    if(i+num==msg.length()-1){
                        answer.add(list.indexOf(temp));
                        flag = true;
                        break;
                    }
                    num++;
                    continue;
                }else{
                    list.add(temp);
                    StringBuilder sb = new StringBuilder();
                    sb.append(temp+"");
                    sb.setLength(sb.length()-1);
                    String strr = sb+"";
                    answer.add(list.indexOf(strr));
                    break;
                }
            }
            if(flag){
                break;
            }
            if(num>1){
                i+=num-1;
            }
        }
        
        return answer;
    }
}