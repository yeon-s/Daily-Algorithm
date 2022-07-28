import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        String answer = "";
        int size = numbers.length;
        String[] arr = new String[size];
        for(int i=0;i<size;i++){
            arr[i] = numbers[i]+"";
        }
        Arrays.sort(arr,new Comparator<String>(){
            public int compare(String o1, String o2){
                return (o1+o2).compareTo(o2+o1);
            }
        });
        
        if(arr[size-1].equals("0")) return "0";
        
        StringBuilder sb = new StringBuilder();
        for(int i=size-1;i>=0;i--){
            sb.append(arr[i]+"");
        }
        
        return sb+"";
    }
}