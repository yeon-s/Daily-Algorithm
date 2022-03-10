import java.util.*;

class Solution {
    public int solution(int[] d, int budget) {
        int answer = 0;
        
        Arrays.sort(d);
        int sum=0;
        
        boolean flag=false;
        for(int i=0;i<d.length;i++){
            sum+=d[i];
            if(sum>budget){
                answer=i;
                flag=true;
                break;
            }
        }
        if(flag){
            return answer;
        }
        return d.length;
    }
}