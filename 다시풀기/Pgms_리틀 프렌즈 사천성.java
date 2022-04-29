import java.util.*;

class Solution {
    
    static char[][] map;
    static int M;
    static int N;
    static int[] di = {-1,1,0,0};
    static int[] dj = {0,0,-1,1};
    public String solution(int m, int n, String[] board) {
        String answer = "";
        
        int size = 0;       //타일 개수
        map = new char[m][n];
        M=m;
        N=n;
        boolean[] arr = new boolean[26];        //어떤 타일이 남아있는지 저장할 배열
        
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                map[i][j] = board[i].charAt(j);
                if(map[i][j]-'A'>=0 && map[i][j]-'Z'<=0){
                    arr[map[i][j]-'A'] = true;
                    size++;
                }
            }
        }
        
        size/=2;        //타일 개수 절반으로
        
        while(true){
            boolean flag = false;   //제거 가능한 타일이 있는지
            
            for(int i=0;i<26;i++){
                if(arr[i]){     //타일이 있으면
                    if(check(i)){      //제거 가능하면
                        answer+= (char)(i+'A')+"";
                        flag=true;
                        size--;
                        arr[i]=false;
                        delete(i);      //맵에서 없애줘야지
                        break;      //다시 A부터 봐야하므로
                    }
                }
            }
            
            if(!flag){      //더 이상 제거할 수 있는 거 없으면
                break;
            }
        }
        
        System.out.println(size);
        if(size>0){
            answer = "IMPOSSIBLE";
        }
        
        return answer;
    }
    
    static void delete(int num){
        char c = (char)(num+'A');
        
        for(int i=0;i<M;i++){
            for(int j=0;j<N;j++){
                if(map[i][j]==c){
                    map[i][j]='.';
                }
            }
        }
    }
    
    static boolean check(int num){
        char c = (char)(num+'A');
        
        for(int i=0;i<M;i++){
            for(int j=0;j<N;j++){
                if(map[i][j]==c){
                    if(bfs(i,j,c)){
                        return true;   
                    }else{
                        return false;
                    }
                }
            }
        }
        
        return false;
    }
    
    static boolean bfs(int nowi,int nowj,char c){
        Queue<Point> queue = new LinkedList<>();
        boolean[][][] visited= new boolean[M][N][4];
        
        queue.offer(new Point(nowi,nowj,-1,0));
        for(int i=0;i<4;i++){
            visited[nowi][nowj][i]=true;
        }
        
        while(!queue.isEmpty()){
            Point p = queue.poll();
            
            if(p.cnt!=0 && map[p.i][p.j]==c){
                return true;
            }
        
            for(int d=0;d<4;d++){
                int nexti = p.i+di[d];
                int nextj = p.j+dj[d];
                
                if(nexti<0 || nexti>=M || nextj<0 || nextj>=N || visited[nexti][nextj][d] ||
                  map[nexti][nextj]=='*'){
                    continue;
                }
                
                if(map[nexti][nextj]=='.' || map[nexti][nextj]==c){
                    if(p.d==d){     //다음 방향이 현재 방향과 같으면
                        queue.offer(new Point(nexti,nextj,d,p.cnt));   
                        visited[nexti][nextj][d]=true;
                    }else{          //한번 꺾기
                        if(p.cnt<2){
                            queue.offer(new Point(nexti,nextj,d,p.cnt+1));
                            visited[nexti][nextj][d]=true;
                        }
                    }
                }
                
            }
        }
        return false;
    }
    
    static class Point{
        int i;
        int j;
        int d;  //출발 방향
        int cnt;    //꺾은 횟수
        public Point(int i,int j,int d, int cnt){
            this.i=i;
            this.j=j;
            this.d=d;
            this.cnt=cnt;
        }
    }
}