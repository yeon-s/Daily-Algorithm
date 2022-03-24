class Solution
{
    public int solution(String s)
    {
        int answer = 0;

        for(int i=0;i<s.length();i++){
            char center = s.charAt(i);
            int left=i-1;
            int right = i+1;
            int cnt=1;
            if(right<s.length() && s.charAt(right)==center){    //짝수검사
                right+=1;
                cnt++;
                while(left>=0 && right<s.length()){
                    if(s.charAt(left)==s.charAt(right)){
                        cnt+=2;
                        left--;
                        right++;
                    }else{
                        break;
                    }
                }
                answer = Math.max(answer,cnt);
            }
            left=i-1;
            right = i+1;
            cnt=1;
            while(left>=0 && right<s.length()){     //홀수검사
                if(s.charAt(left)==s.charAt(right)){
                    cnt+=2;
                    left--;
                    right++;
                }else{
                    break;
                }
            }
            answer = Math.max(answer,cnt);
        }

        return answer;
    }
}