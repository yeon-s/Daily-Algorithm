import java.util.*;

class Solution {
    public int solution(int n, int m, int[][] edge_list, int k, int[] gps_log) {
        int answer = 1000;
        
        int start = gps_log[0];
        int end = gps_log[k-1];
        boolean[][][] visited = new boolean[k][n+1][k];     //몇번째 시간에 몇번 정점에 몇번의 수정으로 방문했는지
        
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
        
        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(start,0));
        
        int time = 1;
        while(!queue.isEmpty()){
            int size = queue.size();
            while(size-->0){
                Point p = queue.poll();
                
                if(time==k){
                    if(p.cur==end){
                        answer = Math.min(answer,p.cnt);
                    }
                    continue;
                }
                
                for(int next:adjList[p.cur]){
                    if(gps_log[time]==next && !visited[time][next][p.cnt]){
                        queue.offer(new Point(next,p.cnt));
                        visited[time][next][p.cnt]=true;
                    }else if(gps_log[time]!=next && !visited[time][next][p.cnt+1]){
                        queue.offer(new Point(next,p.cnt+1));
                        visited[time][next][p.cnt+1]=true;
                    }
                }
            }
            time++;
        }
        
        if(answer==1000){
            answer=-1;
        }
        return answer;
    }
    
    static class Point{
        int cur;        //현재 위치
        int cnt;        //수정 횟수
        
        public Point(int cur, int cnt){
            this.cur = cur;
            this.cnt = cnt;
        }
    }
}