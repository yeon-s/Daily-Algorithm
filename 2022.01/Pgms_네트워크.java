class Solution {
    static boolean[] visited;
    static int N;
    public int solution(int n, int[][] computers) {
        int answer = 0;
        
        visited = new boolean[n];
        N=n;
        
        for(int i=0;i<n;i++){
          if(!visited[i]){
              answer++;
              dfs(i,computers);
          }
        }
        
        return answer;
    }
    
    static void dfs(int current,int[][] computers){
        visited[current]=true;
        
        for(int i=0;i<N;i++){
            if(!visited[i] && computers[current][i]==1 && current!=i){
                dfs(i,computers);
            }
        }
    }
}