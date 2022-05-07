import java.util.*;

class Solution {
    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        
        int[] progress = new int[N+2];
        int[] arrive = new int[N+2];
        
        for(int i=0;i<stages.length;i++){
            progress[stages[i]]++;
        }
        
        arrive[N+1] = progress[N+1];
        for(int i=N;i>0;i--){
            arrive[i]=arrive[i+1]+progress[i];
        }
        
        double[] fail = new double[N+1];
        PriorityQueue<Stage> pq = new PriorityQueue<>();
        for(int i=1;i<=N;i++){
            fail[i] = (double)progress[i]/(double)arrive[i];
            if(arrive[i]!=0){
                pq.offer(new Stage(i,(double)progress[i]/(double)arrive[i]));
            }else {
                pq.offer(new Stage(i,0));
            }
        }
        
        for(int i=0;i<N;i++){
            answer[i] = pq.poll().num;
        }
        
        return answer;
    }
    
    static class Stage implements Comparable<Stage>{
        int num;
        double failure;
        public Stage(int num,double failure){
            this.num=num;
            this.failure=failure;
        }
        public int compareTo(Stage o){
            if(o.failure==this.failure){
                return this.num-o.num;
            }
            if(o.failure>this.failure){
                return 1;
            }else{
                return -1;
            }
        }
    }
}