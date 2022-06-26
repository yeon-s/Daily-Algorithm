import java.util.*;

class Solution {
    static int size;
    static char[] arr;
    static char[] result;
    static boolean[] isSelected;
    static int answer;
    static boolean[] sosu;
    static Map<Integer,Integer> map;
    public int solution(String numbers) {
        answer = 0;
        
        size = numbers.length();
        
        sosu = new boolean[10000000];
        sosu[0]=sosu[1]=true;
        for(int i=2;i*i<sosu.length;i++){
            if(sosu[i]) continue;
            for(int j=i*i;j<sosu.length;j+=i){
                sosu[j]=true;
            }
        }
        
        arr = numbers.toCharArray();
        map = new HashMap<>();
        for(int i=1;i<=size;i++){
            result = new char[i];
            isSelected = new boolean[size];
            perm(0,i);
        }
        return answer;
    }
    
    static void perm(int cnt, int target){
        if(cnt==target){
            String str = new String(result);
            int num = Integer.parseInt(str);
            if(!sosu[num] && !map.containsKey(num)) {
                answer++;
            }
            map.put(num,1);
            return;
        }
        
        for(int i=0;i<size;i++){
            if(isSelected[i]){
                continue;
            }
            
            isSelected[i] = true;
            result[cnt] = arr[i];
            perm(cnt+1,target);
            isSelected[i]=false;
        }
    }
}