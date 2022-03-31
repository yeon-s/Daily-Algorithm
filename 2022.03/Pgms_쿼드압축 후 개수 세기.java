class Solution {
    static int[][] Arr;
    static int[] answer;
    public int[] solution(int[][] arr) {
        answer = new int[2];
        Arr=arr;
        
        int size = arr.length;
        dfs(0,0,size);
        return answer;
    }
    
    static void dfs(int si,int sj,int size){
        int num=Arr[si][sj];
        boolean flag = true;
        loop : for(int i=si;i<si+size;i++){
            for(int j=sj;j<sj+size;j++){
                if(Arr[i][j]!=num){
                    flag=false;
                    break loop;     
                }
            }
        }
        
        if(flag){
            answer[num]++;
            return;
        }else{
            int half = size/2;
            dfs(si,sj,half);
            dfs(si+half,sj,half);
            dfs(si,sj+half,half);
            dfs(si+half,sj+half,half);
        }
    }
}