import java.util.*;

class Solution {
    public int solution(int[][] triangle) {
        int answer = 0;
        
        int size = triangle.length;
        
        int[][] D = new int[size][size];
        D[0][0]=triangle[0][0];
        
        for(int i=1;i<size;i++){
            for(int j=0;j<=i;j++){
                if(j==0){
                    D[i][j]=D[i-1][0]+triangle[i][j];
                }else if(j==i){
                    D[i][j]=D[i-1][j-1]+triangle[i][j];
                }else{
                    D[i][j] = Math.max(D[i-1][j-1],D[i-1][j])+triangle[i][j];
                }
            }
        }
        
        Arrays.sort(D[size-1]);
        answer = D[size-1][size-1];    
        
        
        return answer;
    }
}