import java.util.*;

class Solution {
    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        int userCnt = stages.length;        //유저수
        int[] arr = new int[N+2];           //각 스테이지별 유저 수 저장한 배열
        PriorityQueue<Stage> pq = new PriorityQueue<>();
        
        for(int i=0;i<userCnt;i++){
            arr[stages[i]]++;
        }
        
        int sum=0;      //현재스테이지의 전스테이지까지 도달한 플레이어수
        for(int i=1;i<N+1;i++){
            if(arr[i]==0){
                pq.add(new Stage(i,0));
                continue;
            }
            pq.add(new Stage(i,(double)arr[i]/(double)(userCnt-sum)));
            sum+=arr[i];
        }
        
        for(int i=0;i<N;i++){
            answer[i] = pq.poll().num;
        }
        return answer;
    }
    
    static class Stage implements Comparable<Stage>{
        int num;
        double fail;
        public Stage(int num,double fail){
            this.num=num;
            this.fail=fail;
        }
        
        public int compareTo(Stage o){
            if(this.fail==o.fail) return this.num-o.num;
            if(o.fail>this.fail) return 1;
            else return -1;
        }
    }
}
