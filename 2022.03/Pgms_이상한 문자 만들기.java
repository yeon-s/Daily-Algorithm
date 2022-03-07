import java.util.*;

class Solution {
    public String solution(String s) {
        String answer = "";
        
        String[] arr = s.split(" ",-1);
        System.out.println(Arrays.toString(arr));
        for(int i=0;i<arr.length;i++){
           if(arr[i].equals(" ")){
               answer+=" ";
               continue;
           }
           String str = arr[i];
           String temp="";
          
           for(int j=0;j<str.length();j++){
               char c = str.charAt(j);
               if(j%2==0){
                   temp+=(c+"").toUpperCase();
               }else{
                   temp+=(c+"").toLowerCase();
               }
           }
           answer+=temp+" ";
        }
        
        // if(s.substring(s.length()-1,s.length()).equals(" ")){
        //     return answer;
        // }
        return answer.substring(0,answer.length()-1);
    }
}