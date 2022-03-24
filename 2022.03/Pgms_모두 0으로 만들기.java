import java.util.*;

class Solution {
    static boolean[] visited;
    static long answer;
    static LinkedList<Integer>[] adjList;
    static long[] A;
    public long solution(int[] a, int[][] edges) {
        answer = 0;
        int N = a.length;   //정점 개수
        A=new long[N];
        long sum=0;
        
        adjList = new LinkedList[N];
        for(int i=0;i<N;i++){
            adjList[i]= new LinkedList<>();
            A[i]=a[i];
            sum+=a[i];
        }
        
        if(sum!=0){
            return -1;
        }
        
        for(int i=0;i<edges.length;i++){
            int from = edges[i][0];
            int to = edges[i][1];
            adjList[from].add(to);
            adjList[to].add(from);
        }
        
        visited = new boolean[N];
        dfs(0);
        
        return answer;
    }
    
    static long dfs(int current){
        visited[current]=true;
        
        for(int next:adjList[current]){
            if(!visited[next]){
                A[current] += dfs(next);
            }
        }
        
        answer+=Math.abs(A[current]);
        return A[current];
    }
}