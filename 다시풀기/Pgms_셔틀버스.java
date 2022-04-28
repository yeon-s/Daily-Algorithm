import java.util.*;

class Solution {
    public String solution(int n, int t, int m, String[] timetable) {
        String answer = "";
        
        int[] arr = new int[n];     //셔틀오는 시간 저장할 배열
        arr[0]=540;
        for(int i=1;i<n;i++){
            arr[i]=arr[i-1]+t;
        }
        
        int[] crewTime = new int[timetable.length];
        for(int i=0;i<timetable.length;i++){
            String[] time = timetable[i].split(":",-1);
            crewTime[i] = Integer.parseInt(time[0])*60+Integer.parseInt(time[1]);
        }
        Arrays.sort(crewTime);
        
        int index=0;
        int num=0;
        for(int i=0;i<n;i++){
            num=0;      //태운 승객수
            int busTime = arr[i];
            
            while(true){
                if(crewTime[index]<=busTime && num<m){       //태울수 있으면
                   num++;
                   index++;
                    if(index>=crewTime.length){
                        break;
                    }
                }else{
                    break;
                }
            }
            
            if(index>=crewTime.length){
                break;
            }
        }
        if(index>0){
            index-=1;
        }
        
        int lastTime=0;
        if(num==m){     //마지막 사람 타고 남는 자리 없으면=>무조건 마지막보다 1분전에 와야함
            lastTime = crewTime[index]-1;
        }else{          //마지막 사람 타고 자리 있으면 마지막 버스시간에 맞춰오면 되지
//             if(index==0){       //아무도 못탔으면 마지막 버스시간에 와야지
                
//             }else{
                
//             }
            lastTime = arr[n-1];
        }
        
        int clock = lastTime/60;
        int minute = lastTime%60;
        if(clock<10){
            answer+="0";
        }
        answer+=clock+"";
        answer+=":";
        if(minute<10){
            answer+="0";
        }
        answer+=minute+"";
        return answer;
    }
}