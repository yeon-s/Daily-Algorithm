class Solution {
    public int solution(int n) {
        int answer = 0;
        
        int start=1;
        int end=1;
        int sum=1;
        while(end<=n){
            
            if(sum<=n){
                if(sum==n){
                    answer++;
                }
                end++;
                sum+=end;
            }else {
                sum-=start;
                start++;
            }
        }
        return answer;
    }
}