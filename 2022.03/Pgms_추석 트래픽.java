import java.util.*;

class Solution {
    static Log[] list;
    static int[] endTime;
    public int solution(String[] lines) {
        int answer = 0;
        int size = lines.length;
        
        //각 로그의 시작 시점과 끝나는 시점을 한 배열에 담고 시간순으로 정렬
        list = new Log[size*2];
        
        int[] startTime = new int[size];
        for(int i=0;i<size;i++){
            startTime[i]=timeFunction(lines[i],i,1);
        }
        endTime = new int[size];
        for(int i=0;i<size;i++){
            endTime[i] = timeFunction(lines[i],i,0);
        }
         
        for(int i=0;i<size;i++){
            list[i+size] = new Log(startTime[i],i);
        }
        Arrays.sort(list,new Comparator<Log>(){
           public int compare(Log o1,Log o2){
               return o1.time-o2.time;
           } 
        });
        
        for(int i=0;i<size*2;i++){
            
            int num= list[i].num;
            Map<Integer,Integer> map = new HashMap<>();
            map.put(num,0);
            int plusOne = list[i].time+1000-1;//1초 더한거;
            
            //System.out.println(list[i].time+" "+plusOne);
            
            for(int j=0;j<size;j++){
                int left = startTime[j];
                int right = endTime[j];
                if(list[i].time>=left && list[i].time<=right){
                    map.put(j,0);
                }
            }
            
            for(int j=i;j<size*2;j++){
                if(list[j].time<=plusOne){
                    if(list[j].num!=num){
                        map.put(list[j].num,0);
                    }
                }
            }
            answer = Math.max(answer,map.size());
        }
        
        return answer;
    }
    
    static class Log{
        int time;
        int num;
        public Log(int time,int num){
            this.time=time;
            this.num=num;
        }
    }
    
    static int timeFunction(String str,int i,int flag){
        //i==-1이면 1초 더해주는 로직, 아니면 시작 시점 구하는 로직
         
        String[] arr = str.split(" ");
        String[] time = arr[1].split(":");
        int hour = Integer.parseInt(time[0]);
        int minute = Integer.parseInt(time[1]);
        int second = Integer.parseInt(time[2].substring(0,2));
        int ms = Integer.parseInt(time[2].substring(3,6));
        
        int num = ((hour*3600)+(minute*60)+second)*1000+ms;

        list[i] = new Log(num,i);
        
        if(flag==0){
            return num;
        }

         String temp = (arr[2].substring(0,arr[2].length()-1));
         int going = Integer.parseInt(temp.substring(0,1));
         int goingms=0;
          if(temp.length()>1){
              goingms = Integer.parseInt(temp.substring(2,temp.length()));
          }
         int startNum = num-(going*1000+goingms)+1;
        
        return startNum;

        
    }
}