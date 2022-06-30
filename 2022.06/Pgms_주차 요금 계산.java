import java.util.*;

class Solution {
    static int[] Fees;
    public int[] solution(int[] fees, String[] records) {
        int[] answer;
        
        Fees=fees;
        Map<String,String> inTime = new HashMap<>();
        Map<String,Integer> sumTime = new HashMap<>();
        
        for(int i=0;i<records.length;i++){
            String[] arr = records[i].split(" ");
            if(arr[2].equals("IN")){        //입차시간 기록
                inTime.put(arr[1],arr[0]);
            }else{      //시간 계산
                String str = inTime.get(arr[1]);       //입차시간
                //시간 계산
                int t = func(str,arr[0]);
                sumTime.put(arr[1],sumTime.getOrDefault(arr[1],0)+t);
                inTime.remove(arr[1]);
            }
        }
        
        //남아있는 차들(23:59에 출차)
        for(String str:inTime.keySet()){
            int t = func(inTime.get(str),"23:59");
            sumTime.put(str,sumTime.getOrDefault(str,0)+t);
        }
        
        List<Car> list = new ArrayList<>();
        for(String str:sumTime.keySet()){
            //요금 계산
            int fee = cal(sumTime.get(str));
            list.add(new Car(str,fee));
        }
        
        Collections.sort(list);
        answer = new int[list.size()];
        for(int i=0;i<list.size();i++){
            answer[i]=list.get(i).fee;
        }
        
        return answer;
    }
    
    static int func(String in, String out){
        String[] inArr = in.split(":");
        String[] outArr = out.split(":");
        
        return (Integer.parseInt(outArr[0])*60)+Integer.parseInt(outArr[1])
            -(Integer.parseInt(inArr[0])*60)-Integer.parseInt(inArr[1]);
    }
    
    static int cal(int time){
        if(time<=Fees[0]) return Fees[1];
        int diff = time-Fees[0];
        
        return Fees[1]+((int)Math.ceil((double)diff/(double)Fees[2])*Fees[3]);
    }
    
    static class Car implements Comparable<Car>{
        String num;
        int fee;
        public Car(String num,int fee){
            this.num=num;
            this.fee=fee;
        }
        public int compareTo(Car o){
            return Integer.parseInt(this.num)-Integer.parseInt(o.num);
        }
    }
}