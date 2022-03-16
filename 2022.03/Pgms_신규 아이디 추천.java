import java.util.*;

class Solution {
    public String solution(String new_id) {
        String answer = "";
        
        new_id = new_id.toLowerCase();
        
        String str="";
        for(int i=0;i<new_id.length();i++){
            char c = new_id.charAt(i);
            if(c=='-' || c=='_' || c=='.' || (c-'a'>=0 && c-'z'<=0) || (c-'0'>=0 && c-'9'<=0)){
                if(str.length()>=1 && str.charAt(str.length()-1)=='.' && c=='.'){
                    continue;
                }
                str+=(c+"");
            }
        }
        if(str.charAt(0)=='.'){
            str = str.substring(1,str.length());
        }
        if(str.length()>=1 && str.charAt(str.length()-1)=='.'){
            str = str.substring(0,str.length()-1);
        }
        if(str.equals("")){
            str="a";
        }
        if(str.length()>=16){
            str = str.substring(0,15);
        }
        if(str.length()>=1 && str.charAt(str.length()-1)=='.'){
            str = str.substring(0,str.length()-1);
        }
        if(str.length()<=2){
            char c = str.charAt(str.length()-1);
            str+=(c+"");
            if(str.length()==2){
                str+=(c+"");
            }
        }
        
        answer = str;
        return answer;
    }
}