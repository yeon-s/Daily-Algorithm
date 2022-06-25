class Solution {
    public int[] solution(long begin, long end) {
        int[] answer = new int[(int)end-(int)begin+1];
        
        for(int i=(int)begin;i<=(int)end;i++){
            int temp=0;
            if(i==1) answer[0]=0;
            else answer[i-(int)begin]=1;
            for(int j=2;j*j<=i;j++){
                if(i%j!=0){
                    continue;
                }
                temp = i/j;
                if(temp<=10000000){
                    answer[i-(int)begin]=temp;
                    break;
                }
            }
        }
        
        return answer;
    }
}