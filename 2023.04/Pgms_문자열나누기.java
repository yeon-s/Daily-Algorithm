class Solution {
    public int solution(String s) {
        int answer = 0;
        
        int cnt1 = 1;
        int cnt2 = 0;
        char c1 = s.charAt(0);
        boolean flag = false;
        
        //길이가 1인경우 예외
        if(s.length()==1) return 1;
        
        for(int i=1;i<s.length();i++){
            if(flag) {
                c1 = s.charAt(i);
                flag= false;
                cnt1=1;
                cnt2=0;
                continue;
            }
            
            char c2 = s.charAt(i);
            
            if(c1==c2) cnt1++;
            else cnt2++;
            
            if(cnt1==cnt2) {
                answer++;
                flag= true;
            }
        }
        
        if(!flag) answer++;
        return answer;
    }
    
}
