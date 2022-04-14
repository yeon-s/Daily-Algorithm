import java.util.*;

class Solution {
    static int MOD = 20170805;
    static int[] di = {0,1};
    static int[] dj = {1,0};
    static int M;
    static int N;
    static int[][][] D;
    static int[][] CityMap;
    public int solution(int m, int n, int[][] cityMap) {
        int answer = 0;
        
        D = new int[m][n][2];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                for(int k=0;k<2;k++){
                    D[i][j][k]=-1;
                    
                }
            }
        }
        CityMap=cityMap;
        M=m;
        N=n;
        
        answer = dfs(0,0,0);
        //System.out.println(Arrays.deepToString(D));
        return answer;
    }
    
    static int dfs(int nowi,int nowj,int curD){
        if(D[nowi][nowj][curD]!=-1){
            return D[nowi][nowj][curD]%MOD;
        }
        
        if(nowi==M-1 && nowj==N-1){
            return D[nowi][nowj][curD]=1;
        }
        D[nowi][nowj][curD]=0;
        //System.out.println(nowi+" "+nowj);
        for(int d=0;d<2;d++){
        
            int nexti = nowi+di[d];
            int nextj = nowj+dj[d];
            if(nexti>=M || nextj>=N || CityMap[nexti][nextj]==1){
                continue;
            }
            if(CityMap[nowi][nowj]==2 && curD!=d){
                continue;
            }else{
               D[nowi][nowj][curD] += dfs(nexti,nextj,d);   
            }
        }
        
        return D[nowi][nowj][curD]%MOD;
        
    }
}