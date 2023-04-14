import java.util.*;

class Solution {
    static String[] arr;
    static List<String> list;
    public int solution(String word) {
        int answer = 0;
        
        arr = new String[]{"A","E","I","O","U"};
        list = new ArrayList<>();
        
        for(int i=1;i<=5;i++){
            perm(0,i,"");
        }
        
        Collections.sort(list);
        answer = list.indexOf(word);
        return answer+1;
    }
    
    static void perm(int cnt,int R,String str){
        if(cnt==R){
            list.add(str);
            return;
        }
        
        for(int i=0;i<5;i++){
            str+=arr[i];
            perm(cnt+1,R,str);
            str = str.substring(0,str.length()-1);
        }
    }
}
