class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;
        int size = sizes.length;
        int max = 0;
        int sidemax=0;
        
        for(int i=0;i<size;i++){
            int up = Math.max(sizes[i][0],sizes[i][1]);
            int down = Math.min(sizes[i][0],sizes[i][1]);
            max = Math.max(max,up);
            sidemax = Math.max(sidemax,down);
        }
        
        return max*sidemax;
    }
}
