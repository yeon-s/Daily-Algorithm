import java.util.*;

class Solution {
    public String solution(String play_time, String adv_time, String[] logs) {
        String answer = "";
        
        int playTime = change(play_time);
        int[] arr = new int[playTime];
        
        int advTime = change(adv_time);
        
        for(String s:logs){
            String startTime = s.substring(0,8);
            String endTime = s.substring(9,17);
            int start = change(startTime);
            int end = change(endTime);
            for(int i=start;i<end;i++){
                arr[i]++;
            }
        }
        
        //슬라이딩윈도우
        long time = 0;
        int maxIndex = playTime-advTime;
        for(int i=playTime-advTime;i<playTime;i++){
            time+=arr[i];
        }
        long max = time;
        
        for(int i=playTime-advTime;i>0;i--){
            int in = arr[i-1];
            int out = arr[i-1+advTime];
            
            time = time-out+in;
            if(time>=max){
                max = time;
                maxIndex = i-1;
            }
        }
      
        int hour= maxIndex/3600;
        if(hour<10){
            answer+=0;
        }
        answer+=hour;
        answer+=":";
        maxIndex -=hour*3600;
        int min = maxIndex/60;
        if(min<10){
            answer+=0;
        }
        answer+=min;
        answer+=":";
        maxIndex -=min*60;
        if(maxIndex<10){
            answer+=0;
        }
        answer+=maxIndex;
           
        return answer;
    }
    
    static int change(String str){
        int th = (int)(str.charAt(0)-'0');
        int oh = (int)(str.charAt(1)-'0');
        int tm = (int)(str.charAt(3)-'0');
        int om = (int)(str.charAt(4)-'0');
        int ts = (int)(str.charAt(6)-'0');
        int os = (int)(str.charAt(7)-'0');
        
        return (((th*10)+oh)*3600)+(((tm*10)+om)*60)+((ts*10)+os);
    }
}