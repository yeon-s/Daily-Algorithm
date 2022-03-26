class Solution {
    public double solution(int[] arr) {
        double answer = 0;
        
        int size= arr.length;
        int[] pSum = new int[size];
        pSum[0]=arr[0];
        for(int i=1;i<size;i++){
            pSum[i]=arr[i]+pSum[i-1];
        }
        
        answer = (double)pSum[size-1]/size;
        return answer;
    }
}