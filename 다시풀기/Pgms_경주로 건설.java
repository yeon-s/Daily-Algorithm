import java.util.*;

class Solution {
    static int[] di = {-1,1,0,0};
    static int[] dj = {0,0,-1,1};
    public int solution(int[][] board) {
        int answer = 1000000;
        
        int size = board.length;
        PriorityQueue<Point> pq = new PriorityQueue<>();
        int[][][] D = new int[size][size][4];
        boolean[][][] visited = new boolean[size][size][4];
        for(int i=0;i<size;i++){
            for(int j=0;j<size;j++){
                for(int d=0;d<4;d++){
                    D[i][j][d] = 1000000;
                }
            }
        }
        pq.offer(new Point(0,0,0,0));
        D[0][0][0]=0;
        D[0][0][1]=0;
        D[0][0][2]=0;
        D[0][0][3]=0;
        
        while(!pq.isEmpty()){
            Point p = pq.poll();
            
            if(visited[p.i][p.j][p.d]){
                continue;
            }
            
            visited[p.i][p.j][p.d]=true;
            
            for(int d=0;d<4;d++){
                int nexti = p.i+di[d];
                int nextj = p.j+dj[d];
                
                if(nexti<0 || nextj<0 || nexti>=size || nextj>=size || board[nexti][nextj]==1
                  || visited[nexti][nextj][d]){
                    continue;
                }
                
                if(p.i==0 && p.j==0){        //처음 출발장소
                    D[nexti][nextj][d] = p.weight+100;
                    pq.offer(new Point(nexti,nextj,d,D[nexti][nextj][d]));
                }else{              //출발장소 아니면
                    int more =0;
                    if(p.d==d){     //직진하면
                        more=100;
                    }else{
                        more=600;
                    }
                    
                    if(D[nexti][nextj][d]>p.weight+more){
                            D[nexti][nextj][d]=p.weight+more;
                            pq.offer(new Point(nexti,nextj,d,D[nexti][nextj][d]));
                    }
                    
                }
            }
        }
        for(int d=0;d<4;d++){
            answer = Math.min(answer,D[size-1][size-1][d]);
        }
        return answer;
    }
    
    static class Point implements Comparable<Point>{
        int i;
        int j;
        int d;
        int weight;
        public Point(int i,int j, int d,int weight){
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