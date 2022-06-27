import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer;
        
        int size = progresses.length;   //작업 개수
        int arr[] = new int[size];        //작업당 걸리는 시간
        
        for(int i=0;i<size;i++){
            int time = (int)Math.ceil((double)(100-progresses[i])/speeds[i]);
            arr[i] = time;
        }
        
        List<Integer> list = new ArrayList<>();
        
        int temp=arr[0];
        int cnt=1;
        for(int i=1;i<size;i++){
            if(arr[i]<=temp){
                cnt++;
            }else{
                list.add(cnt);
                temp=arr[i];
                cnt=1;
            }
        }
        list.add(cnt);
        
        answer = new int[list.size()];
        for(int i=0;i<list.size();i++){
            answer[i]=list.get(i);
        }
        return answer;
    }
}