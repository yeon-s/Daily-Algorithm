import java.util.*;

class Solution {
    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        
        int[] arr = new int[N+2];
        int[] D = new int[N+2];
        
        for(int i=0;i<stages.length;i++){
            arr[stages[i]]++;
        }
        D[N+1]=arr[N+1];
        for(int i=N;i>=1;i--){
            D[i] = D[i+1]+arr[i];
        }
        PriorityQueue<Stage> pq = new PriorityQueue<>();
        for(int i=1;i<=N;i++){
            double fail;
            if(D[i]==0){
                fail=0;
            }else{
                fail = (double)arr[i]/D[i];
            }
            pq.offer(new Stage(i,fail));
        }
        
        for(int i=0;i<N;i++){
            answer[i]=pq.poll().num;
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
            if(o.fail==this.fail){
                return this.num-o.num;
            }
            if(o.fail>this.fail){
                return 1;
            }else{
                return -1;
            }
        }
    }
}