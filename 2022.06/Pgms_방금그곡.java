import java.util.*;

class Solution {
    public String solution(String m, String[] musicinfos) {
        String answer = "";
        int size = musicinfos.length;
        m= m.replace("A#","a").replace("C#","c").replace("D#","d").replace("F#","f").replace("G#","g");
        
        PriorityQueue<Song> pq = new PriorityQueue<>();
        for(int i=0;i<size;i++){
            String[] arr = musicinfos[i].split(",");
            int playTime = func(arr[0],arr[1]);
            String melody = arr[3];
            melody= melody.replace("A#","a").
                replace("C#","c").replace("D#","d").replace("F#","f").replace("G#","g");
            
            String temp = "";
            if(playTime<=melody.length()){
                temp = melody.substring(0,playTime);
            }else{
                int cnt = playTime/melody.length();
                int nam = playTime%(melody.length());
                
                while(cnt-->0){
                    temp+=melody;
                }
                if(nam!=0) temp+=melody.substring(0,nam);
            
            }
            
            if(temp.contains(m)) pq.offer(new Song(arr[2],playTime,i));
            
        }
        
        if(pq.isEmpty()) return "(None)";
        answer = pq.poll().title;
        return answer;
    }
    
    static class Song implements Comparable<Song>{
        String title;
        int playTime;
        int idx;
        public Song(String title, int playTime, int idx){
            this.title=title;
            this.playTime=playTime;
            this.idx=idx;
        }
        public int compareTo(Song o){
            if(this.playTime==o.playTime) return this.idx-o.idx;
            return o.playTime-this.playTime;
        }
    }
    
    static int func(String start, String end){
        int s = change(start);
        int e = change(end);
        return e-s; 
    }
    
    static int change(String str){
        String[] arr = str.split(":");
        return Integer.parseInt(arr[0])*60+Integer.parseInt(arr[1]);
    }
}