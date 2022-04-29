class Solution {
    static char[][] map;
    static boolean[][] visited;
    static boolean flag;
    static int[] di = {-1,1,0,0};
    static int[] dj = {0,0,-1,1};
    public int[] solution(String[][] places) {
        int[] answer = new int[5];
        
        for(int t=0;t<5;t++){
            map = new char[5][5];
            visited = new boolean[5][5];
            flag=false;
            for(int i=0;i<5;i++){
                for(int j=0;j<5;j++){
                    map[i][j] = places[t][i].charAt(j);
                }
            }
            
            for(int i=0;i<5;i++){
                for(int j=0;j<5;j++){
                    if(map[i][j]=='P'){
                        dfs(i,j,0);
                    }
                }
            }
            if(flag){
                answer[t]=0;
            }else{
                answer[t]=1;
            }
        }
        return answer;
    }
    
    static void dfs(int nowi,int nowj,int cnt){
        if(flag || cnt>=2){
            return;
        }
        visited[nowi][nowj]=true;
        
        for(int d=0;d<4;d++){
            int nexti = nowi+di[d];
            int nextj = nowj+dj[d];
            
            if(nexti<0 || nexti>=5 || nextj<0 || nextj>=5 || map[nexti][nextj]=='X' || visited[nexti][nextj]){
                continue;
            }
            
            if(map[nexti][nextj]=='P'){
                flag=true;
                return;
            }
            dfs(nexti,nextj,cnt+1);
        }
    }
}