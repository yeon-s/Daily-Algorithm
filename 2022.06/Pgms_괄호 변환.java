class Solution {
    public String solution(String p) {
        String answer = "";
        
        answer = func(p);
        return answer;
    }
    
    static String func(String str){
        if(str.equals("")) return "";
        
        int cnt=0;
        int idx=0;
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)=='(') cnt++;
            else cnt--;
            
            if(cnt==0){
                idx=i;
                break;
            }
        }
        
        String u = str.substring(0,idx+1);
        String v = "";
        if(idx+1!=str.length()) v=str.substring(idx+1,str.length());
        
        //u가 올바른 괄호 문자열인지 확인
        if(check(u)){
            return u+func(v);
        }else{
            String temp ="(";
            temp+=func(v);
            temp+=")";
            u=u.substring(1,u.length()-1);
            //괄호방향 뒤집기
            String str2="";
            for(int i=0;i<u.length();i++){
                if(u.charAt(i)=='(') str2+=")";
                else str2+="(";
            }
            return temp+str2;
        }
    }
    
    static boolean check(String str){
        int cnt=0;
        int idx=0;
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)=='(') cnt++;
            else cnt--;
            
            if(cnt<0){
                return false;
            } 
        }
        
        if(cnt!=0) return false;
        return true;
    }
}