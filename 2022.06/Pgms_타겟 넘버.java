class Solution {
    static int answer;
    static int[] Numbers;
    static int Target;
    static int size;
    public int solution(int[] numbers, int target) {
        answer=0;
        Numbers=numbers;
        Target = target;
        size = numbers.length;
        
        dfs(0,0);
        return answer;
    }
    
    static void dfs(int sum,int cnt){
        if(cnt==size){
            if(sum==Target) answer++;
            return;
        }
        int temp=sum+Numbers[cnt];
        dfs(temp,cnt+1);
        temp=sum-Numbers[cnt];
        dfs(temp,cnt+1);
    }
}