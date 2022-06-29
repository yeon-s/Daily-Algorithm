class Solution {
    static char[][] map;
    static int M;
    static int N;
    static int cnt;
    static boolean[][] checked;
    static int[] di = {0,1,1};
    static int[] dj = {1,0,1};
    public int solution(int m, int n, String[] board) {
        int answer = 0;
        
        M=m;
        N=n;
        map = new char[m][n];
        for(int i=0;i<m;i++){
            String str = board[i];
            for(int j=0;j<n;j++){
                map[i][j] = str.charAt(j);
            }
        }
        
        
        while(true){
            cnt=0;
            checked= new boolean[m][n];
            
            check();
            delete();
            down();
            
            if(cnt==0) break;
            answer+=cnt;
        }
        return answer;
    }
    
    static void down(){
        for(int j=0;j<N;j++){
            int temp=-1;
            for(int i=M-1;i>0;i--){
                if(map[i][j]=='e'){
                    for(int k=i-1;k>=0;k--){
                        if(map[k][j]!='e'){
                            map[i][j]=map[k][j];
                            map[k][j]='e';
                            break;
                        }
                    }
                }
            }
        }
    }
    
    static void delete(){
        for(int i=0;i<M;i++){
            for(int j=0;j<N;j++){
                if(checked[i][j]){
                    cnt++;
                    map[i][j] = 'e';
                }
            }
        }
    }
    
    static void check(){
        for(int i=0;i<M-1;i++){
            for(int j=0;j<N-1;j++){
                char c = map[i][j];
                if(c=='e') continue;
                boolean flag = true;        //false면 다른거
                
                //주변 3개 같은지 체크
                for(int d=0;d<3;d++){
                    int nexti = i+di[d];
                    int nextj = j+dj[d];
                    
                    if(map[nexti][nextj]!=c){
                        flag=false;
                        break;
                    }
                }
                
                if(flag){
                    checked[i][j]=true;
                    for(int d=0;d<3;d++){
                        int nexti = i+di[d];
                        int nextj = j+dj[d];
                        
                        checked[nexti][nextj]=true;
                    }
                }
            }
        }
    }
}