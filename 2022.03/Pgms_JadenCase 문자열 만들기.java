import java.util.*;

class Solution {
    public String solution(String s) {
        String answer = "";
        
        String[] arr = s.split(" ");
        
        for(int i=0;i<arr.length;i++){
            String str = arr[i];
            if(str.equals("")){
                answer+=" ";
                continue;
            }
            if(str.charAt(0)-'0'>=0 && str.charAt(0)-'0'<=9){
                char c = str.charAt(0);
                str = str.substring(1,str.length()).toLowerCase();
                arr[i]="";
                arr[i]+=(c+"");
                arr[i]+=str;
            }else{
                String first = (str.charAt(0)+"").toUpperCase();
                str=str.substring(1,str.length()).toLowerCase();
                arr[i]="";
                arr[i]+=first;
                arr[i]+=str;
            }
            answer+=(arr[i]+" ");
        }
        if(s.substring(s.length()-1,s.length()).equals(" ")){
            return answer;
        }
        answer = answer.trim();
        return answer;
    }
}