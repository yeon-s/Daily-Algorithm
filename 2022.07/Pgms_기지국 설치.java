class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;

        int length = (w*2)+1;
        int right=0;
        for(int i=0;i<stations.length;i++){
            int index = stations[i];
            int left = index-w;
            
            if(right<left-1) answer+= (int)Math.ceil((double)(left-1-right)/length);
            right = index+w;
        }
        
        if(right<n) answer+= (int)Math.ceil((double)(n-right)/length);

        return answer;
    }
}