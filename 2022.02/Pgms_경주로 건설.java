import java.util.*;

class Solution {
    static int[] di ={-1,1,0,0};
    static int[] dj = {0,0,-1,1};
    static int size;
    static int[][] Board;
    static int answer;
    public int solution(int[][] board) {
        answer = Integer.MAX_VALUE;
        
        size = board.length;
        this.Board=board;
        
        dijkstra();
        
        return answer;
    }
    
    static void dijkstra(){
        int[][][] d = new int[size][size][4];
        boolean[][][] visited = new boolean[size][size][4];
        for(int i=0;i<size;i++){
            for(int j=0;j<size;j++){
                for(int k=0;k<4;k++){
                    d[i][j][k] = 600000;
                }
            }
        }
        
        PriorityQueue<Point> pq = new PriorityQueue<>();
        pq.offer(new Point(0,0,1,0));
        pq.offer(new Point(0,0,3,0));
        d[0][0][0]=0;
        d[0][0][1]=0;
        d[0][0][2]=0;
        d[0][0][3]=0;
        
        while(!pq.isEmpty()){
            Point cur = pq.poll();
            
            if(visited[cur.i][cur.j][cur.d]){
                continue;
            }
            
            visited[cur.i][cur.j][cur.d]=true;
            
            for(int D=0;D<4;D++){
                int nexti = cur.i+di[D];
                int nextj = cur.j+dj[D];
                
                if(nexti<0 || nextj<0 || nexti>=size || nextj>=size || 
                   visited[nexti][nextj][cur.d] || Board[nexti][nextj]==1){
                    continue;
                }
                
                if(cur.d==D){
                    if(d[nexti][nextj][D]>cur.weight+100){
                        d[nexti][nextj][D]=cur.weight+100;
                        pq.offer(new Point(nexti,nextj,D,d[nexti][nextj][D]));
                    }
                }else{
                    if(d[nexti][nextj][D]>cur.weight+600){
                        d[nexti][nextj][D]=cur.weight+600;
                        pq.offer(new Point(nexti,nextj,D,d[nexti][nextj][D]));
                    }
                }
            }
        }
        
        for(int i=0;i<4;i++){
            answer = Math.min(d[size-1][size-1][i],answer);
        }
    }
    
    static class Point implements Comparable<Point>{
        int i;
        int j;
        int d;
        int weight;
        public Point(int i,int j,int d,int weight){
            this.i=i;
            this.j=j;
            this.d=d;
            this.weight=weight;
        }
        
        public int compareTo(Point o){
            return this.weight-o.weight;
        }
    }
    
}