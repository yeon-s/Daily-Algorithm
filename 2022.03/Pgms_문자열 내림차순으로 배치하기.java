import java.util.*;

class Solution {
    public String solution(String s) {
        String answer = "";
        
        String[] arr = s.split("");
        Arrays.sort(arr, new Comparator<String>(){
            public int compare(String o1, String o2){
                return o2.compareTo(o1);
            }
        });
        for(int i=0;i<arr.length;i++){
            answer+=arr[i]+"";
        }
        
        return answer;
    }
}