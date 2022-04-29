import java.util.*;

class Solution {
    static Map<String,Integer> map1;
    static Map<String,Integer> map2;
    public int solution(String str1, String str2) {
        int answer = 0;
        
        map1 = new HashMap<>();
        map2 = new HashMap<>();
        
        inputMap(str1,1);
        inputMap(str2,2);
        
        double common = 0;
        double sum=0;
        
        for(String str:map1.keySet()){
            if(map2.containsKey(str)){
                common+= Math.min(map1.get(str),map2.get(str));
                sum+= Math.max(map1.get(str),map2.get(str));
            }else{
                sum+=map1.get(str);
            }
        }
        
        //2에 있는거 합집합에 포함해주기
        for(String str:map2.keySet()){
            if(!map1.containsKey(str)){
                sum+=map2.get(str);
            }
        }
        
        if(common==0 && sum==0){
            return 65536;
        }
        
        answer = (int)((common/sum)*65536);
        
        return answer;
    }
    
    static void inputMap(String str,int num){
        for(int i=0;i<str.length()-1;i++){
            String temp = str.substring(i,i+2);
            temp = temp.toLowerCase();
            if(!check(temp)){
                continue;
            }
            if(num==1){
                map1.put(temp, map1.getOrDefault(temp,0)+1);
            }else{
                map2.put(temp, map2.getOrDefault(temp,0)+1);
            }
        }
    }
    
    static boolean check(String str){
        char c1 = str.charAt(0);
        char c2 = str.charAt(1);
        
        if(c1-'a'<0 || c1-'z'>0){
            return false;
        }
        if(c2-'a'<0 || c2-'z'>0){
            return false;
        }
        return true;
    }
}