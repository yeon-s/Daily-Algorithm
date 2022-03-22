import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        
        int size = truck_weights.length;
        int[] time = new int[size];
        int index = 0;
        int sum=0;
        LinkedList<Integer> list = new LinkedList<>();
        
        while(true){
            answer++;
            
            if(sum+truck_weights[index]<=weight && list.size()<bridge_length){
                sum+=truck_weights[index];
                list.add(index);
                index++;
            }
            
            //큐에 있는 애들 시간++;
            for(int i:list){
                time[i]++;
            }
            
            //큐.peek해서 가장 앞에있는 애 시간 보고
            //다리 통과면 큐에서 빼고 sum에서 통과한 무게 빼고
            if(list.size()>0 && time[list.get(0)]>=bridge_length){
                int num = list.removeFirst();
                sum-=truck_weights[num];
            }
            if(index>=size){
                break;
            }
        }
        
        answer+=bridge_length;
        return answer;
    }
}