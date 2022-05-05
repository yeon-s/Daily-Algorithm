import java.util.*;

class Solution {
    public int solution(int n, int m, int[][] edge_list, int k, int[] gps_log) {
        int answer = 1000;
        
        int start = gps_log[0];
        int end = gps_log[k-1];
        
        LinkedList<Integer>[] adjList = new LinkedList[n+1];
        for(int i=1;i<=n;i++){
            adjList[i] = new LinkedList<>();
            adjList[i].add(i);      //머물수도 있다.
        }
        for(int i=0;i<m;i++){
            int from = edge_list[i][0];
            int to = edge_list[i][1];
            adjList[from].add(to);
            adjList[to].add(from);
        }
        
        int[][] D = new int[n+1][k];
        for(int i=0;i<=n;i++){
            for(int j=0;j<k;j++){
                D[i][j] = 1000;
                if(j==0 && i==start){
                    D[i][j]=0;
                }
            }
        }
        
        for(int j=0;j<k-1;j++){
            for(int i=1;i<=n;i++){
                if(D[i][j]!=1000){
                    for(int next:adjList[i]){
                        if(next==gps_log[j+1]){
                            D[next][j+1] = Math.min(D[next][j+1],D[i][j]);
                        }else{
                            D[next][j+1] = Math.min(D[next][j+1],D[i][j]+1);
                        }
                    }
                }
            }
        }
        
        answer = D[end][k-1];
        if(answer==1000){
            answer=-1;
        }
        return answer;
    }
    
}