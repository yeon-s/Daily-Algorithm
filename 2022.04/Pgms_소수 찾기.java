class Solution {
    public int solution(int n) {
        int answer = 0;

        boolean[] sosu = new boolean[n+1];
        //에라토스테네스의 체
        for(int i=2;i<=n;i++){
            if(sosu[i]){
                continue;
            }
            for(int j=i*2;j<=n;j+=i){
                sosu[j]=true;                
            }
        }
        
        for(int i=2;i<=n;i++){
            if(!sosu[i]){
                answer++;
            }
        }
        
        return answer;
    }
}