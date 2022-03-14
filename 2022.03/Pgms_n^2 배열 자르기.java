class Solution {
    public int[] solution(int n, long left, long right) {
        int[] answer = new int[(int)(right-left)+1];
        
        int index=0;
        for(long i=left;i<=right;i++){
            long moc = i/n;
            long nam = i%n;
            long ans =0;
            if(moc<=nam){
                ans=nam+1;
            }else {
                ans = moc+1;
            }
            
            answer[index] = (int)ans;
            index++;
        }
        return answer;
    }
}