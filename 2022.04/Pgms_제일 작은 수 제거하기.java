import java.util.*;

class Solution {
    public List<Integer> solution(int[] arr) {
        int size = arr.length;
        List<Integer> list = new ArrayList<>();
        
        if(size==1){
           list.add(-1);
           return list;
        }
        int min = Integer.MAX_VALUE;
        for(int i=0;i<size;i++){
            min = Math.min(min,arr[i]);
        }
        for(int i=0;i<size;i++){
            if(arr[i]==min){
                continue;
            }
            list.add(arr[i]);
        }
        return list;
    }
}