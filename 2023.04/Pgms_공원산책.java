class Solution {
    static int N;
    static int M;
    static int nowi,nowj;
    static int[] di = {-1,1,0,0};
    static int[] dj = {0,0,-1,1};
    public int[] solution(String[] park, String[] routes) {
        int[] answer = new int[2];
        
        N = park.length;
        M = park[0].length();
        
        char[][] map = new char[N][M];
        
        for(int i=0;i<N;i++){
            String str = park[i];
            for(int j=0;j<M;j++){
                map[i][j] = str.charAt(j);
                if(map[i][j]=='S'){
                    nowi = i;
                    nowj = j;
                }
            }
        }
        
        for(int i=0;i<routes.length;i++){
            String[] arr = routes[i].split(" ");
            String s = arr[0];
            int cnt = Integer.parseInt(arr[1]);
            
            int tempi = nowi;
            int tempj = nowj;
            boolean flag = true;
            
            for(int j=0;j<cnt;j++){
                if(s.equals("E")){
                    tempj+=dj[3];     
                }else if(s.equals("W")){
                    tempj+=dj[2];
                }else if(s.equals("S")){
                    tempi+=di[1];
                }else if(s.equals("N")){
                    tempi+=di[0];
                }
                if(tempi<0 || tempi>=N || tempj<0 || tempj>=M || map[tempi][tempj]=='X') {
                    flag = false;
                    break;
                }
            }
            
            System.out.println(tempi+" "+tempj);
            if(!flag) continue;
            nowi = tempi;
            nowj = tempj;
            
        }
        
        answer[0] = nowi;
        answer[1] = nowj;
        
        return answer;
    }
    
}
