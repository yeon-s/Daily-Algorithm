import java.util.*;

class Solution {
    static int[] di = {-1,0,1,0};
    static int[] dj = {0,-1,0,1};
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        int answer = 0;
        
        int[][] map = new int[51][51];
        int[][][] path = new int[51][51][4];
        for(int k=0;k<rectangle.length;k++){
            int lj = rectangle[k][0];
            int li = rectangle[k][1];
            int rj = rectangle[k][2];
            int ri = rectangle[k][3];
            
            for(int i=li;i<ri;i++){
                for(int j=lj;j<rj;j++){
                    map[i][j]=2;
                }
            }
        }
        
        //bfs돌면서 길 만들기
        Queue<Point> queue = new LinkedList<>();
        boolean[][] visited = new boolean[51][51];
        queue.offer(new Point(0,0));
        visited[0][0]=true;
        
        while(!queue.isEmpty()){
            Point cur = queue.poll();
            
            for(int d=0;d<4;d++){
                int nexti = cur.i+di[d];
                int nextj = cur.j+dj[d];
                
                if(nexti<0 || nextj<0 || nexti>50 || nextj>50 || visited[nexti][nextj]){
                    continue;
                }
                
                if(map[nexti][nextj]==0){
                    queue.offer(new Point(nexti,nextj));
                    visited[nexti][nextj]=true;
                }else if(map[nexti][nextj]==2){
                    int lD=d-1;
                    int rD=d+1;
                    if(lD<0){
                        lD=3;
                    }
                    if(rD>3){
                        rD=0;
                    }
                    if(d==0){
                       path[cur.i][cur.j][lD]=1;
                        //범위 생각(안넘어감)
                       path[cur.i][cur.j+1][rD]=1;
                    }else if(d==1){
                        path[cur.i][cur.j][rD]=1;
                        path[cur.i+1][cur.j][lD]=1;
                    }else if(d==2){
                        path[nexti][nextj][rD]=1;
                        path[nexti][nextj+1][lD]=1;
                    }else if(d==3){
                        path[nexti][nextj][lD]=1;
                        path[nexti+1][nextj][rD]=1;
                    }
                }     
            }
        }
        
        queue.clear();
        visited = new boolean[51][51];
        queue.offer(new Point(characterY,characterX));
        visited[characterY][characterX]=true;
        
        while(!queue.isEmpty()){
            int size = queue.size();
            while(size-->0){
                Point cur = queue.poll();
                
                if(cur.i==itemY && cur.j==itemX){
                    return answer;
                }
                
                for(int d=0;d<4;d++){
                    if(path[cur.i][cur.j][d]==1){
                        int nexti = cur.i+di[d];
                        int nextj = cur.j+dj[d];
                        
                        if(!visited[nexti][nextj]){
                            queue.offer(new Point(nexti,nextj));
                            visited[nexti][nextj]=true;
                        }
                    }
                }
            }
            answer++;
        }
        return 0;
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