class Solution {
    boolean solution(String s) {
        boolean answer = false;

        s= s.toLowerCase();
        int p = 0;
        int y = 0;
        
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(c=='p'){
                p++;
            }else if(c=='y'){
                y++;
            }
        }

        if(p==y){
            return true;
        }
        return answer;
    }
}