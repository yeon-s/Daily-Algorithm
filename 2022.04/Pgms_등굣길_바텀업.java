import java.util.*;

class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int answer = 0;
        
        int[][] D = new int[n][m];
        
        
        for(int i=0;i<puddles.length;i++){
            D[puddles[i][1]-1][puddles[i][0]-1]=-1;
        }
        
        for(int i=0;i<n;i++){
            if(D[i][0]==-1){
                break;
            }
            D[i][0]=1;
        }
        for(int j=0;j<m;j++){
            if(D[0][j]==-1){
                break;
            }
            D[0][j]=1;
        }
        
        
        for(int i=1;i<n;i++){
            for(int j=1;j<m;j++){
                if(D[i][j]==-1){
                    continue;
                }
                if(D[i-1][j]!=-1){
                    D[i][j]+=D[i-1][j]%1000000007;
                }
                if(D[i][j-1]!=-1){
                    D[i][j]+=D[i][j-1]%1000000007;
                }
                D[i][j]%=1000000007;
            }
        }
        
        //System.out.println(Arrays.deepToString(D));
        
        answer = D[n-1][m-1];
        return answer;
    }
}