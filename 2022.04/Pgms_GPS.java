import java.util.*;

class Solution {
    public int solution(int n, int m, int[][] edge_list, int k, int[] gps_log) {
        int answer = Integer.MAX_VALUE;
        
        LinkedList<Integer>[] adjList = new LinkedList[n+1];
        
        for(int i=1;i<=n;i++){
            adjList[i] = new LinkedList<>();
            adjList[i].add(i);
        }
        
        for(int i=0;i<m;i++){
            int from = edge_list[i][0];
            int to = edge_list[i][1];
            adjList[from].add(to);
            adjList[to].add(from);
        }
        
        int[][] D = new int[k][n+1];
        
        for(int i=0;i<k;i++){
            for(int j=1;j<=n;j++){
                D[i][j] = Integer.MAX_VALUE;
            }
        }
        D[0][gps_log[0]]=0;
        
        for(int i=1;i<k-1;i++){
            for(int j=1;j<=n;j++){
                
                for(int pre:adjList[j]){
                    if(D[i-1][pre]!=Integer.MAX_VALUE){
                        if(j==gps_log[i]){
                            D[i][j] = Math.min(D[i][j],D[i-1][pre]);
                        }else{
                            D[i][j] = Math.min(D[i][j],D[i-1][pre]+1);
                        }
                    }
                    
                }
            }
        }
        
        for(int pre:adjList[gps_log[k-1]]){
            if(D[k-2][pre]!=Integer.MAX_VALUE){
                answer = Math.min(Integer.MAX_VALUE,D[k-2][pre]);
            }
        }
        if(answer==Integer.MAX_VALUE){
            answer=-1;
        }
        return answer;
    }
}