import java.util.*;

class Solution {
    public String solution(String m, String[] musicinfos) {
        String answer = "";
        
        m = change(m);
        
        PriorityQueue<Music> pq = new PriorityQueue<>();
        
        int size = musicinfos.length;
        for(int i=0;i<size;i++){
            String temp = musicinfos[i];
            
            String[] arr = temp.split(",");
            int playtime = cal(arr[0],arr[1]);
            String title = arr[2];
            String melody = arr[3];
            melody = change(melody);
            String tmp = "";
            
            if(playtime>melody.length()){
                int cnt = playtime/melody.length();
                int nam = playtime%melody.length();
                
                while(cnt-->0){
                    tmp+=melody;
                }
                tmp+=melody.substring(0,nam);
            }else{
                tmp = melody.substring(0,playtime);
            }
            
            if(tmp.contains(m)){
               pq.offer(new Music(playtime,i+1,title));
            }
        }
        
        if(pq.isEmpty()){
            answer = "(None)";
        }else{
            answer = pq.poll().title;
        }
        
        return answer;
    }
    
    static class Music implements Comparable<Music>{
        int playtime;
        int index;
        String title;
        public Music(int playtime,int index,String title){
            this.playtime=playtime;
            this.index=index;
            this.title=title;
        }
        
        public int compareTo(Music o){
            if(o.playtime==this.playtime){
                return this.index-o.index;
            }else{
                return o.playtime-this.playtime;
            }
        }
    }
    
    static int cal(String start,String end){
        String[] arr1 = start.split(":");
        String[] arr2 = end.split(":");
        
        int time = Integer.parseInt(arr2[0])-Integer.parseInt(arr1[0]);
        int minute = Integer.parseInt(arr2[1])-Integer.parseInt(arr1[1]);
        if(minute<0){
            minute+=60;
            time-=1;
        }
        
        return time*60+minute;
    }
    
    static String change(String str){
        str = str.replace("A#","H");
        str = str.replace("C#","I");
        str = str.replace("D#","J");
        str = str.replace("F#","K");
        str = str.replace("G#","L");
        
        return str;
    }
}