class Solution {
    static boolean[][] visited;
    static int[] di = {-1,1,0,0};
    static int[] dj = {0,0,-1,1};
    static int M;
    static int N;
    static int[][] map;
    static int cnt;
    public int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;

        visited = new boolean[m][n];
        M=m;
        N=n;
        map = picture;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(picture[i][j]!=0 && !visited[i][j]){
                    numberOfArea++;
                    cnt=0;
                    dfs(i,j,picture[i][j]);
                    maxSizeOfOneArea = Math.max(maxSizeOfOneArea,cnt);
                }
            }
        }
        
        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }
    
    static void dfs(int nowi,int nowj,int num){
        visited[nowi][nowj]=true;
        cnt++;
        
        for(int d=0;d<4;d++){
            int nexti = nowi+di[d];
            int nextj = nowj+dj[d];
            
            if(nexti<0 || nextj<0 || nexti>=M || nextj>=N || visited[nexti][nextj] || map[nexti][nextj]!=num){
                continue;
            }
            
            dfs(nexti,nextj,num);
        }
    }
}