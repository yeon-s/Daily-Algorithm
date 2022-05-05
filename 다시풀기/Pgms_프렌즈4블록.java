class Solution {
    static boolean[][] selected;
    static char[][] map;
    static int answer;
    static int[] di={0,1,1};
    static int[] dj={1,0,1};
    static int M;
    static int N;
    public int solution(int m, int n, String[] board) {
        answer = 0;
        
        map = new char[m][n];
        M=m;
        N=n;
        //맵에 채우기
        for(int i=0;i<m;i++){
            String str = board[i];
            for(int j=0;j<n;j++){
                map[i][j]=str.charAt(j);
            }
        }
        
        while(true){
            
            boolean flag=false;      //터진게 있는지 확인
            
            selected = new boolean[m][n];
            
            for(int i=0;i<m-1;i++){
                for(int j=0;j<n-1;j++){
                    if(map[i][j]!='0'){
                        check(i,j,map[i][j]);
                    }
                }
            }
            
            for(int i=0;i<m;i++){
                for(int j=0;j<n;j++){
                    if(selected[i][j]){
                        answer++;
                        flag=true;
                        map[i][j]='0';
                    }
                }
            }
            
            if(!flag){
                break;
            }
            fall();
        }
        return answer;
    }
    
    static void fall(){
        
        for(int j=0;j<N;j++){
            
            for(int i=M-1;i>0;i--){
                if(map[i][j]=='0'){
                    int temp=i-1;
                    while(temp>=0){
                        if(map[temp][j]!='0'){
                            map[i][j]=map[temp][j];
                            map[temp][j]='0';
                            break;
                        }
                        temp--;
                    }
                }
            }
        }
    }
    
    static void check(int nowi,int nowj,char what){
        
        for(int d=0;d<3;d++){
            int nexti = nowi+di[d];
            int nextj = nowj+dj[d];
            
            if(map[nexti][nextj]!=what){
                return;
            }
        }
        
        //여기오면 네개 다 같은 블록
        selected[nowi][nowj]=true;
        for(int d=0;d<3;d++){
            int nexti = nowi+di[d];
            int nextj = nowj+dj[d];
            
            selected[nexti][nextj]=true;
        }
    }
}