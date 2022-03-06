class Solution {
    public long solution(long price, int money, long count) {
        long answer = -1;
        
        long sum = (count*( (2*price) + ((count-1)*price)))/2;
        
        if(sum>money){
            answer = sum-money;
        }else{
            answer=0;
        }        

        return answer;
    }
}