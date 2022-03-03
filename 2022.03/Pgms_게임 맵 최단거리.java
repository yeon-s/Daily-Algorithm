import java.util.*;

class Solution {
    static int[] di = {-1,1,0,0};
    static int[] dj = {0,0,-1,1};
    public int solution(int[][] maps) {
        int answer = -1;
        
        int n = maps.length;
        int m = maps[0].length;
        
        Queue<Point> queue = new LinkedList<>();
        boolean[][] visited = new boolean[n][m];
        queue.offer(new Point(0,0));
        visited[0][0]=true;
        
        int cnt=1;
        while(!queue.isEmpty()){
            int size = queue.size();
            while(size-->0){
                Point cur = queue.poll();
                
                if(cur.i==n-1 && cur.j==m-1){
                    answer = cnt;
                    return answer;
                }
                
                for(int d=0;d<4;d++){
                    int nexti = cur.i+di[d];
                    int nextj = cur.j+dj[d];
                    
                    if(nexti<0 || nextj<0 || nexti>=n || nextj>=m || 
                       maps[nexti][nextj]==0 || visited[nexti][nextj]){
                        continue;
                    }
                    
                    queue.offer(new Point(nexti,nextj));
                    visited[nexti][nextj]=true;
                }
            }
            cnt++;
        }
        
        return answer;
    }
    
    static class Point{
        int i;
        int j;
        public Point(int i,int j){
            this.i=i;
            this.j=j;
        }
    }
}