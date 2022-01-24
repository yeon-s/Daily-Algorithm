class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        
        int y=1;
        int x = (brown/2)-y+2;
        while(true){
            if(x>=y && x*y==brown+yellow){
                break;
            }
            y++;
            x = (brown/2)-y+2;
        }
        
        answer[0]=x;
        answer[1]=y;
        
        
        return answer;
    }
}