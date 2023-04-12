class Solution {
    public int solution(int n, int m, int[] section) {
        int answer = 0;
        
        int max = 0;
        for(int i: section){
            if(i<max) continue;
            
            answer++;
            max = i+m;
        }
        return answer;
    }
}
