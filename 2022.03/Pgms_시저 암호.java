import java.util.*;

class Solution {
    public String solution(String s, int n) {
        String answer = "";
        
        char[] arr = new char[52];
        char[] arr2 = new char[52];
        int idx = 0;
        for(int i=0;i<52;i++){
            arr[i] = (char)('a'+idx);
            arr2[i] = (char)('A'+idx);
            idx++;
            if(idx>=26){
                idx=0;
            }
        }
        
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(c==' '){
                answer+=" ";
                continue;
            }
            
            if(c-'a'>=0 && c-'z'<=0){
                int index = c-'a';
                index+=n;
                answer+=(arr[index]+"");
            }else if(c-'A'>=0 && c-'Z'<=0){
                int index = c-'A';
                index+=n;
                answer+=(arr2[index]+"");
            }
        }
        
        return answer;
    }
}