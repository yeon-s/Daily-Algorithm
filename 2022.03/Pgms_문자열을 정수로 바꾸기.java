class Solution {
    public int solution(String s) {
        int answer = 0;
        
        boolean flag = true;
        if(s.charAt(0)=='+' || s.charAt(0)=='-'){
            if(s.charAt(0)=='-'){
                flag= false;
            }
            s=s.substring(1,s.length());
            
        }
        
        answer = Integer.parseInt(s);
        if(!flag){
            answer*=-1;
        }
        return answer;
    }
}