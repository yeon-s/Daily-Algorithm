import java.util.*;

class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;
        int size = sizes.length;
        
        int[] big = new int[size];
        int[] small = new int[size];
        
        for(int i=0;i<size;i++){
            big[i] = Math.max(sizes[i][0],sizes[i][1]);
            small[i] = Math.min(sizes[i][0],sizes[i][1]);
        }
        
        Arrays.sort(big);
        Arrays.sort(small);
        
        answer = big[size-1]*small[size-1];
        return answer;
    }
}