class Solution {
    public String solution(String s) {
        String answer = "";
        
        int size = s.length();
        
        int num = size/2;
        if(size%2==0){
            answer+= (s.charAt(num-1)+"");
            answer+= (s.charAt(num)+"");
        }else{
            answer+= (s.charAt(num)+"");
        }
        return answer;
    }
}