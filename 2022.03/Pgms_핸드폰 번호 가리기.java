class Solution {
    public String solution(String phone_number) {
        String answer = "";
        
        int size = phone_number.length();
        int num = size-4;
        for(int i=0;i<num;i++){
            answer+="*";
        }
        answer+= phone_number.substring(num,size);
        return answer;
    }
}