import java.util.*;

class Solution {
    static LinkedList<Integer>[] adjList;
    static boolean[] visited;
    static int[] Info;
    static int max;
    static int size;
    //static boolean[] available;
    public int solution(int[] info, int[][] edges) {
        int answer = 0;
        
        Info=info;
        size= info.length;
        adjList = new LinkedList[size];
        for(int i=0;i<size;i++){
            adjList[i] = new LinkedList<>();
        }
        for(int i=0;i<edges.length;i++){
            int parent = edges[i][0];
            int child = edges[i][1];
            adjList[parent].add(child);
        }
        
        visited = new boolean[size];
        max=0;
        boolean[] available = new boolean[size];
        available[0]=true;
        dfs(0,1,0,available);
        answer =max;
        return answer;
    }
    
    static void dfs(int current,int sheep,int wolf,boolean[] available){
        if(wolf>=sheep){
            return;
        }
        visited[current]=true;
        max=Math.max(max,sheep);
        //System.out.println(current+" "+sheep+" "+wolf);
        boolean[] temp = new boolean[size];
        
        for(int next:adjList[current]){
            temp[next]=true;
        }
        for(int i=0;i<size;i++){
            if(available[i]){
                temp[i]=true;
            }
        }
        
        available = temp;
        for(int i=0;i<size;i++){
            if(available[i] &&!visited[i]){
                if(Info[i]==0){
                    dfs(i,sheep+1,wolf,available);
                }else {
                    dfs(i,sheep,wolf+1,available);
                }
                visited[i]=false;
            }
        }
    }
    
}