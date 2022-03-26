import java.util.*;

public class Solution {
    public List<Integer> solution(int []arr) {
        
        List<Integer> list = new ArrayList<>();
        int num = arr[0];
        list.add(num);
    
        for(int i=1;i<arr.length;i++){
            if(arr[i]!=num){
                num=arr[i];
                list.add(num);
            }
        }
        return list;
    }
}