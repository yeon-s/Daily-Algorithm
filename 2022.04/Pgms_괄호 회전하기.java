import java.util.*;

class Solution {
    static Stack<Character> stack;
    public int solution(String s) {
        int answer = 0;
        
        int size = s.length();
        stack = new Stack<>();
        
        while(size-->1){
            stack.clear();
            if(s.charAt(0)==')' || s.charAt(0)=='}' || s.charAt(0)==']'){
                s+= s.charAt(0)+"";
                s=s.substring(1,s.length());
                continue;
            }
            if(check(s)){
                answer++;
            }
            
            s+= s.charAt(0)+"";
            s=s.substring(1,s.length());
        }
        return answer;
    }
    
    static boolean check(String str){
        for(int i=0;i<str.length();i++){
            char ch = str.charAt(i);
            if(ch=='(' || ch=='[' || ch=='{'){
                stack.push(str.charAt(i));
            }else{
                if(stack.isEmpty()){
                    return false;
                }
                char c = stack.pop();
                if((ch==']' && c=='[') || (ch=='}' && c=='{') || (ch==')' && c=='(') ){
                    continue;
                }else{
                    return false;
                }
            }
        }
        if(!stack.isEmpty()){
            return false;
        }
        return true;
    }
}