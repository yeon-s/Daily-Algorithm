import java.util.*;

class Solution {
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        
        Queue<String> queue = new LinkedList<>();
        queue.offer(begin);
        Set<String> set = new HashSet<>();
        set.add(begin);
        int num=0;
        boolean flag=false;
        
        while(!queue.isEmpty()){
            int size = queue.size();
            while(size-->0){
                String current = queue.poll();
                if(current.equals(target)){
                    flag=true;
                    break;
                }
                for(int i=0;i<words.length;i++){
                    if(!set.contains(words[i]) && check(current,words[i])){
                        queue.offer(words[i]);
                        set.add(words[i]);
                    }
                }
                
            }
            if(flag){
                break;
            }
            num++;
        }  
        answer=num;
        if(!flag){
            answer=0;
        }
        return answer;
    }
    
    static boolean check(String current, String compare){
        char[] arr = current.toCharArray();
        char[] arr2 = compare.toCharArray();
        int num=0;
        
        for(int i=0;i<arr.length;i++){
            if(arr[i] != arr2[i]){
                num++;
            }
        }
        if(num==1){
            return true;
        }else{
            return false;
        }
    }
}