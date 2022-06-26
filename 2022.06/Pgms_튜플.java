import java.util.*;

class Solution {
    public int[] solution(String s) {
        int[] answer;
        
        s= s.replace("{","");
        s= s.replace("},"," ");
        s= s.replace("}","");
        String[] arr = s.split(" ");
        // for(int i=0;i<arr.length;i++){
        //     System.out.println(arr[i]);
        // }
        
        Map<String,Integer> map = new HashMap<>();
        for(int i=0;i<arr.length;i++){
            String[] arr2 = arr[i].split(",");
            for(int j=0;j<arr2.length;j++){
                map.put(arr2[j],map.getOrDefault(arr2[j],0)+1);
            }
        }
        
        answer = new int[map.size()];
        for(String str:map.keySet()){
            answer[map.size()-map.get(str)] = Integer.parseInt(str);
        }
        return answer;
    }
    
    static class Number{
        int num;
        int cnt;
        public Number(int num,int cnt){
            this.num=num;
            this.cnt=cnt;
        }
    }
}