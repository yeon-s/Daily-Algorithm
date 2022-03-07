import java.util.*;

class Solution {
    public String solution(String s) {
        String answer = "";
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        PriorityQueue<Integer> pq2 = new PriorityQueue<>(new Comparator<>(){
            public int compare(Integer o1, Integer o2){
                return o2-o1;
            }
        });
        
        String[] arr = s.split(" ");
        for(int i=0;i<arr.length;i++){
            pq.offer(Integer.parseInt(arr[i]));
            pq2.offer(Integer.parseInt(arr[i]));
        }
        
        answer+=(pq.poll()+""+" ");
        answer+=(pq2.poll()+"");
        return answer;
    }
}