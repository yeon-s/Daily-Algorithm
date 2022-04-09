import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int num = commands.length;
        int[] answer = new int[num];
        
        for(int i=0;i<num;i++){
            int start = commands[i][0];
            int end = commands[i][1];
            int k = commands[i][2];
            
            int[] arr = new int[end-start+1];
            for(int j=start-1;j<end;j++){
                arr[j-start+1] = array[j];
            }
            Arrays.sort(arr);
            answer[i] = arr[k-1];
        }
        return answer;
    }
}