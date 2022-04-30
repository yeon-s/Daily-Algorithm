import java.util.*;

class Solution {
    public String solution(String play_time, String adv_time, String[] logs) {
        String answer = "";
        
        int endTime = change(play_time);
        long[] arr = new long[endTime];
        
        PriorityQueue<Time> pq = new PriorityQueue<>();
        for(int i=0;i<logs.length;i++){
            String[] temp = logs[i].split("-");
            int st = change(temp[0]);
            pq.offer(new Time(st,true));
            int end = change(temp[1]);
            pq.offer(new Time(end,false));
        }
        
        int index=0;
        int user=0;
        while(!pq.isEmpty()){
            Time t = pq.poll();
        
            for(int i=index;i<t.time;i++){
                arr[i]+=user;
            }
            
            if(t.isStart){
                user++;
            }else{
                user--;
            }
            index=t.time;
        }
        
        int advTime = change(adv_time);
        
        //누적합 풀이
        for(int i=1;i<endTime;i++){
            arr[i]+=arr[i-1];
        }
        
        long max = arr[advTime-1];
        int ans=0;
        for(int i=0;i<endTime-advTime;i++){
            long diff = arr[i+advTime]-arr[i];
            if(diff>max){
                max=diff;
                ans=i;
            }
        }
        if(max!=arr[advTime-1]){
            ans+=1;
        }
        
        answer = change2(ans);
        
        return answer;
    }
    
    static String change2(int num){
        String str="";
        
        int h = num/3600;
        num-=h*3600;
        if(h<10){
            str+="0";
        }
        str+=h+""+":";
        int m = num/60;
        num-=m*60;
        if(m<10){
            str+="0";
        }
        str+=m+""+":";
        if(num<10){
            str+="0";
        }
        str+=num+"";
        return str;
        
    }
    
    static int change(String str){
        String[] arr = str.split(":");
        
        return (3600*Integer.parseInt(arr[0]))+(60*Integer.parseInt(arr[1]))+Integer.parseInt(arr[2]);
    }
    
    static class Time implements Comparable<Time>{
        int time;
        boolean isStart;
        public Time(int time,boolean isStart){
            this.time=time;
            this.isStart=isStart;
        }
        public int compareTo(Time o){
            return this.time-o.time;
        }
    }
}