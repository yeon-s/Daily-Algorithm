class Solution {
    static int[] di = {-1,1,0,0};
    static int[] dj = {0,0,-1,1};
    public int solution(String dirs) {
        int answer = 0;
        
        boolean[][][] visited = new boolean[11][11][4];
        char[] arr = dirs.toCharArray();
        int[] dir = new int[arr.length];
        for(int i=0;i<dir.length;i++){
            if(arr[i]=='U') dir[i]=0;
            if(arr[i]=='D') dir[i]=1;
            if(arr[i]=='L') dir[i]=2;
            if(arr[i]=='R') dir[i]=3;
        }
        
        int nowi = 5;
        int nowj = 5;
        for(int i=0;i<dir.length;i++){
            if(!visited[nowi][nowj][dir[i]]){
                answer++;
            }
            
            visited[nowi][nowj][dir[i]]=true;
            
            int nexti = nowi+di[dir[i]];
            int nextj = nowj+dj[dir[i]];
            if(nexti<0 || nextj<0 || nexti>10 || nextj>10){
                visited[nowi][nowj][dir[i]]=false;
                answer--;
                continue;
            }
            int opD = 0;
            if(dir[i]==0) opD=1;
            if(dir[i]==1) opD=0;
            if(dir[i]==2) opD=3;
            if(dir[i]==3) opD=2;
            visited[nexti][nextj][opD]=true;
            nowi=nexti;
            nowj=nextj;
        }
        
        return answer;
    }
    
}