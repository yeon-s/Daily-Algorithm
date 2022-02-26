class Solution
{
    public int solution(int n, int a, int b)
    {
        int answer = 0;

        while(true){
            int num = Math.abs(b-a);
            answer++;
            if(num==1 && (a/2)!=(b/2)){
                break;
            }
            if(a%2==1){
                a = (a+1)/2;
            }else{
                a/=2;
            }
            if(b%2==1){
                b = (b+1)/2;
            }else{
                b/=2;
            }
        }
        return answer;
    }
}