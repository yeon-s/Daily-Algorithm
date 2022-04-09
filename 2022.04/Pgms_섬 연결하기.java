import java.util.*;

class Solution {
    public int solution(int n, int[][] costs) {
        int answer = 0;
        
        int[] d = new int[n];
        LinkedList<Node>[] adjList = new LinkedList[n];
        for(int i=0;i<n;i++){
            adjList[i] = new LinkedList<>();
            d[i] = Integer.MAX_VALUE;
        }
        
        int size = costs.length;
        for(int i=0;i<size;i++){
            adjList[costs[i][0]].add(new Node(costs[i][1],costs[i][2]));
            adjList[costs[i][1]].add(new Node(costs[i][0],costs[i][2]));
        }
        
        boolean[] visited = new boolean[n];
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(0,0));
        d[0]=0;
        
        while(!pq.isEmpty()){
            Node cur = pq.poll();
            
            if(visited[cur.vertex]){
                continue;
            }
            
            visited[cur.vertex]=true;
            answer+=cur.weight;
            
            for(Node node : adjList[cur.vertex]){
                if(!visited[node.vertex] && d[node.vertex]>node.weight){
                    d[node.vertex] = node.weight;
                    pq.offer(new Node(node.vertex,d[node.vertex]));
                }
            }
        }
        
        return answer;
    }
    
    static class Node implements Comparable<Node>{
        int vertex;
        int weight;
        public Node(int vertex,int weight){
            this.vertex=vertex;
            this.weight=weight;
        }
        public int compareTo(Node o){
            return this.weight-o.weight;
        }
    }
}