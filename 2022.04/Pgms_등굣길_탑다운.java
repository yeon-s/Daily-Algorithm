import java.util.*;

class Solution {
    static int[] di = {0,1};
    static int[] dj = {1,0};
    static int M;
    static int N;
    static int[][] D;
    public int solution(int m, int n, int[][] puddles) {
        int answer = 0;
        
        M=m;
        N=n;
        D = new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                D[i][j]=-1;
            }
        }
        
        for(int i=0;i<puddles.length;i++){
            D[puddles[i][1]-1][puddles[i][0]-1]=-2;
        }
        
        dfs(0,0);
        //System.out.println(Arrays.deepToString(D));
        answer = D[0][0];
        return answer;
    }
    
    static int dfs(int nowi,int nowj){
        if(D[nowi][nowj]!=-1){
            return D[nowi][nowj]%1000000007;
        }
        
        if(nowi==N-1 && nowj==M-1){
            return 1;
        }
        
        D[nowi][nowj]=0;
        
        for(int d=0;d<2;d++){
            int nexti = nowi+di[d];
            int nextj = nowj+dj[d];
            
            if(nexti>=N || nextj>=M || D[nexti][nextj]==-2){
                continue;
            }
            
            D[nowi][nowj]+=dfs(nexti,nextj);
            D[nowi][nowj]%=1000000007;
        }
        
        return D[nowi][nowj]%1000000007;
    }
}