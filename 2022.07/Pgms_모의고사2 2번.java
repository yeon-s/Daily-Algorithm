import java.util.*;

class Solution {
    static int size;
    static String[] Want;
    static int[] Number;
    static Map<String,Integer> map;
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        size = want.length;
        Want=want;
        Number=number;
        //슬라이딩윈도우
        //10일 동안 들어있는 과일들과 개수 저장할 맵
        map = new HashMap<>();
        //처음 10일 담기
        for(int i=0;i<10;i++){
            String fruit = discount[i];
            map.put(fruit,map.getOrDefault(fruit, 0)+1);
        }

        if(check()) answer++;

        for(int i=10;i<discount.length;i++){
            String plus = discount[i];
            map.put(plus, map.getOrDefault(plus,0)+1);
            String minus = discount[i-10];
            int cnt = map.get(minus);
            if(cnt>0) map.put(minus, cnt-1);
            if(check()) answer++;
        }

        return answer;
    }
    static boolean check(){
        for(int i=0;i<size;i++){
            //맵에 없으면
            if(!map.containsKey(Want[i])) return false;
            //있으면 개수 확인
            int count = map.get(Want[i]);
            if(Number[i]>count) return false;
        }
        //여기까지 오면 충족된거
        return true;
    }
}