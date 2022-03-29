import java.util.*;

class Solution {
    public String solution(String m, String[] musicinfos) {
        String answer = "";
        
        m=m.replace("A#","1");
        m=m.replace("C#","2");
        m=m.replace("D#","3");
        m=m.replace("F#","4");
        m=m.replace("G#","5");
        
        PriorityQueue<Music> pq = new PriorityQueue<>();
        
        for(int i=0;i<musicinfos.length;i++){
            String[] str = musicinfos[i].split(",",-1);
            String[] start = str[0].split(":");
            String[] end = str[1].split(":");
            String title = str[2];
            String melody = str[3];
            
            melody = melody.replace("A#","1");
            melody = melody.replace("C#","2");
            melody = melody.replace("D#","3");
            melody = melody.replace("F#","4");
            melody = melody.replace("G#","5");
            
            //조건에 맞으면 pq에 추가
            int playTime = 0;
            int hour = Integer.parseInt(end[0])-Integer.parseInt(start[0]);
            if(Integer.parseInt(start[1])>Integer.parseInt(end[1])){
                playTime = ((hour-1)*60)+Integer.parseInt(end[1])+60-Integer.parseInt(start[1]);
            }else{
                playTime = (hour*60)+Integer.parseInt(end[1])-Integer.parseInt(start[1]);
            }
            
            //멜로디 만들기
            if(playTime<=melody.length()){
                melody = melody.substring(0,playTime);
               
            }else{
                int moc = playTime/melody.length();
                int nam = playTime%melody.length();
                
                StringBuilder sb = new StringBuilder();
                sb.append(melody);
                
                while(moc-->1){
                    sb.append(melody);
                    //melody+=melody;
                }
                if(nam>0){
                    sb.append(melody.substring(0,nam));
                }
                
                melody = sb+"";
            }
            
            if(m.length()>melody.length()){
                    continue;
                }
            
            if(melody.contains(m)){
                pq.offer(new Music(i+1,title,playTime));
            }
            
        }
        
        if(pq.isEmpty()){
            return "(None)";
        }
        answer = pq.poll().title;
        return answer;
    }
    
    static class Music implements Comparable<Music>{
        int index;
        String title;
        int playTime;
        public Music(int index,String title,int playTime){
            this.index=index;
            this.title=title;
            this.playTime=playTime;
        }
        public int compareTo(Music o){
            if(this.playTime==o.playTime){
                return this.index-o.index;
            }
            return o.playTime-this.playTime;
        }
    }
}