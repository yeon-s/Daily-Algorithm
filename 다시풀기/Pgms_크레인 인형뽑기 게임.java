import java.util.*;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        
        Stack<Integer> basket = new Stack<>();
        
        int size = moves.length;
        int r = board.length;
        for(int k=0;k<size;k++){
            int target = moves[k]-1;
            
            int select = -1;
            for(int i=0;i<r;i++){
                if(board[i][target]>0){
                    select = board[i][target];
                    board[i][target]=0;
                    break;
                }
            }
            
            if(select!=-1){     //뽑았으면
                if(!basket.isEmpty() && basket.peek()==select){
                    basket.pop();
                    answer+=2;
                }else{
                    basket.push(select);
                }
            }
        }
        
        
        return answer;
    }
}