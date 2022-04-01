class Solution {
    static int answer;
    public int solution(int num) {
        answer = 0;
        
        dfs(num,0);
        
        return answer;
    }
    
    static void dfs(long num,int cnt){
        if(num==1){
            answer=cnt;
            return;
        }
        if(cnt>=500){
            answer=-1;
            return;
        }
        
        if(num%2==0){
            dfs(num/2,cnt+1);
        }else{
            dfs((num*3)+1,cnt+1);
        }
    }
}