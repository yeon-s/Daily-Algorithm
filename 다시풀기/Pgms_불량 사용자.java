import java.util.*;

class Solution {
    static int r;
    static int c;
    static boolean[] isSelected;
    static int[] result;
    static Map<String,Integer> map;
    static boolean[][] check;
    public int solution(String[] user_id, String[] banned_id) {
        int answer = 1;
        r=banned_id.length;
        c=user_id.length;
        isSelected = new boolean[c];
        result = new int[r];
        map = new HashMap<>();
        
        check = new boolean[banned_id.length][user_id.length];
        
        int[] arr = new int[banned_id.length];
        for(int i=0;i<banned_id.length;i++){
            String str = banned_id[i];
            
            int cnt=0;
            for(int j=0;j<user_id.length;j++){
                String temp = user_id[j];
                if(str.length()!=temp.length()){
                    continue;
                }
                
                boolean flag=true;
                for(int k=0;k<str.length();k++){
                    if(str.charAt(k)=='*'){
                        continue;
                    }
                    if(str.charAt(k)!=temp.charAt(k)){
                        flag=false;
                        break;
                    }
                }
                
                if(flag){
                    check[i][j]=true;
                }
            }
        }
        
        perm(0);
        answer = map.size();
        return answer;
    }
    
    static void perm(int cnt){
        if(cnt==r){
            
            int[] temp = new int[r];
            for(int i=0;i<r;i++){
                temp[i]=result[i];
            }
            Arrays.sort(temp);
            StringBuilder sb = new StringBuilder();
            for(int i=0;i<r;i++){
                sb.append(temp[i]+"");
            }
            map.put(sb+"",1);
            return;
        }
        
        for(int i=0;i<c;i++){
            if(isSelected[i] || !check[cnt][i]){
                continue;
            }
            
            result[cnt]=i;
            isSelected[i]=true;
            perm(cnt+1);
            isSelected[i]=false;
        }
    }
}