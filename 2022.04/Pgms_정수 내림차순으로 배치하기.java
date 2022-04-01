import java.util.*;

class Solution {
    public long solution(long n) {
        long answer = 0;
        
        String str = n+"";
        int size = str.length();
        char[] arr =str.toCharArray();
        Arrays.sort(arr);
        
        String ans = "";
        for(int i=size-1;i>=0;i--){
            ans+=arr[i]-'0';
        }
        answer = Long.parseLong(ans);
        
        return answer;
    }
}