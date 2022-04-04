class Solution {
    public int solution(int n) {
        int answer = 0;
        
        String str = Integer.toString(n,2);
        
        int k=0;
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)=='1'){
                k++;
            }
        }
        
        for(int i=n+1;i<=1000000;i++){
            String temp = Integer.toString(i,2);
            int cnt=0;
            for(int j=0;j<temp.length();j++){
                if(temp.charAt(j)=='1'){
                    cnt++;
                }
            }
            if(cnt==k){
                answer = Integer.parseInt(temp,2);
                break;
            }
        }
        
        return answer;
    }
}