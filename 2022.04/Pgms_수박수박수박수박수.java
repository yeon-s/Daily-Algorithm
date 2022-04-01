class Solution {
    public String solution(int n) {
        String answer = "";
        
        int cnt = n/2;
        StringBuilder sb = new StringBuilder();
        while(cnt-->0){
            sb.append("수박");
        }
        if(n%2==1){
            sb.append("수");
        }
        answer = sb+"";
        return answer;
    }
}