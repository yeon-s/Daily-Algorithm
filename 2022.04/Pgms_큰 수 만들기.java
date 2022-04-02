class Solution {
    public String solution(String number, int k) {
        String answer = "";
        
        StringBuilder sb = new StringBuilder();
        int size = number.length();
        int cnt = size-k;
        int current =-1;
        while(true){
            int max=0;
            for(int i=current+1;i<=size-cnt;i++){
                if(number.charAt(i)-'0'>max){
                    max = number.charAt(i)-'0';
                    current=i;
                }
            }
            sb.append(max);
            cnt--;
            if(cnt<=0){
                break;
            }
        }
        answer = sb+"";
        return answer;
    }
}