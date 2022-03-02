import java.util.*;

class Solution {
    public String solution(String p) {
        String answer = "";
        
        //올바른 괄호 문자열이면 리턴
        if(check(p)){
            return p;
        }
        //아니라면
        answer = dfs(p);
        
        return answer;
    }
    
    static String dfs(String p){
        if(p.equals("")){
            return "";
        }
        
        String u="";
        String v = "";
        int f=0;
        int b=0;
        for(int i=0;i<p.length();i++){
            if(p.charAt(i)=='('){
                u+="(";
                f++;
            }else{
                u+=")";
                b++;
            }
            if(f!=0 && f==b){
               if(i<p.length()-1){
                   v = p.substring(i+1,p.length());
               }
                break;
            }
        }
        
        if(check(u)){
            u+=dfs(v);
            return u;
        }else{
            String str = "(";
            str+=dfs(v);
            str+=")";
            
            u=u.substring(1,u.length()-1);
            String temp = "";
            for(int i=0;i<u.length();i++){
                if(u.charAt(i)=='('){
                    temp+=")";
                }else{
                    temp+="(";
                }
            }
            str+=temp;
            return str;
        }
        
    }
    
    static boolean check(String str){
        Stack<Character> stack = new Stack<>();
        
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)=='('){
                stack.push('(');
            }else{
                if(stack.isEmpty()){
                    return false;
                }
                stack.pop();
            }
        }
        
        if(stack.isEmpty()){
            return true;
        }
        return false;
    }
}