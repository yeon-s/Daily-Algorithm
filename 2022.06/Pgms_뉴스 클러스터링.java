import java.util.*;

class Solution {
    static Map<String, Integer> map1;
    static Map<String, Integer> map2;
    public int solution(String str1, String str2) {
        int answer = 0;
        
        map1 = new HashMap<>();
        map2 = new HashMap<>();
        check(str1,map1);
        check(str2,map2);
        
        int size1 = 0;
        int size2 = 0;
        for(String str:map1.keySet()){
            size1+=map1.get(str);
        }
        for(String str:map2.keySet()){
            size2+=map2.get(str);
        }
        
        int cnt = 0;        //겹치는 개수
        for(String str:map1.keySet()){
            if(map2.containsKey(str)){
                if(map2.get(str)>0){
                    int temp1 = map1.get(str);
                    int temp2 = map2.get(str);
                    cnt+=Math.min(temp1,temp2);
                    map2.put(str,temp2-Math.min(temp1,temp2));
                }
            }
        }
        
        double zacard=0;
        if((size1+size2)==0 && cnt==0){
            zacard=1;
        }else{
            zacard = (double)cnt/(double)(size1+size2-cnt);
        }
        
        answer = (int)(zacard*65536);
        return answer;
    }
    
    static void check(String temp, Map<String,Integer> map){
        for(int i=0;i<temp.length()-1;i++){
            String str = temp.substring(i,i+2);
            str = str.toLowerCase();
            char c1 = str.charAt(0);
            char c2 = str.charAt(1);
            if(c1-'a'>=0 && c1-'z'<=0 && c2-'a'>=0 && c2-'z'<=0){
                map.put(str,map.getOrDefault(str,0)+1);
            }
        }
    }
}