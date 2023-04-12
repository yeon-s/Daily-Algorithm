class Solution {
    public int solution(int number, int limit, int power) {
        int answer = 0;
        
        for(int i=1;i<=number;i++){
            int cnt = cal(i);
            
            answer += (cnt>limit) ? power : cnt;
        }
        return answer;
    }
    
    static int cal(int num){
        int cnt=0;      //약수 개수
        for(int i=1;i*i<=num;i++){
            if(i*i==num) cnt++;
            else if(num%i==0) cnt+=2;
        }
        return cnt;
    }
}
