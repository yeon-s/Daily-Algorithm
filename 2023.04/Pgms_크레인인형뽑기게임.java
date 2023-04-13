import java.util.*;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        int size = board.length;
        Stack<Integer> stack = new Stack<>();
        
        for(int i=0;i<moves.length;i++){
            int idx = moves[i]-1;
            
            for(int j=0;j<size;j++){
                int s = board[j][idx];
                if(s!=0){
                    if(!stack.isEmpty()){
                        int what = stack.peek();
                        if(what==s){
                            answer+=2;
                            stack.pop();
                            board[j][idx]=0;
                            break;
                        }
                    }
                    stack.push(s);
                    board[j][idx]=0;
                    break;
                }
            }
        }
        
        return answer;
    }
}
