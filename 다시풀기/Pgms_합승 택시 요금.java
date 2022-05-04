class Solution {
    public int solution(int n, int s, int a, int b, int[][] fares) {
        int answer = 0;
        
        int[][] adjMatrix = new int[n+1][n+1];
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
                if(i==j){
                    continue;
                }
                adjMatrix[i][j] = 100000000;
            }
        }
        for(int i=0;i<fares.length;i++){
            for(int j=0;j<3;j++){
                int from = fares[i][0];
                int to = fares[i][1];
                int weight = fares[i][2];
                adjMatrix[from][to] = weight;
                adjMatrix[to][from] = weight;
            }
        }
        
        //플로이드 워샬
        for(int k=1;k<=n;k++){
            for(int i=1;i<=n;i++){
                if(i==k){
                    continue;
                }
                for(int j=1;j<=n;j++){
                    if(j==i || j==k){
                        continue;
                    }
                    adjMatrix[i][j] = Math.min(adjMatrix[i][j],adjMatrix[i][k]+adjMatrix[k][j]);
                }
            }
        }
       
        answer = adjMatrix[s][a]+adjMatrix[s][b];
        for(int i=1;i<=n;i++){
            answer = Math.min(answer,adjMatrix[s][i]+adjMatrix[i][a]+adjMatrix[i][b]);
        }
        return answer;
    }
}