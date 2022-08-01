import java.util.*;

class Solution {
    static List<String> list;
    public int[][] solution(int n) {
        int[][] answer;
        
        list = new ArrayList<>();
        hanoi(n,1,2,3);
        
        answer = new int[list.size()][2];
        
        for(int i=0;i<list.size();i++){
            String str = list.get(i);
            answer[i][0] = str.charAt(0)-'0';
            answer[i][1] = str.charAt(2)-'0';
        }
        return answer;
    }
    
    static void hanoi(int n, int start, int temp, int end){
        if(n==0) return;
        
        //자신 위에 있는 n-1개 들어내기 : 임시기둥으로 옮기기
        hanoi(n-1,start,end,temp);
        //자신 원판 옮기기
        list.add(start+" "+end);
        //들어냈던 임시기둥에 있는 n-1개 자기로 옮기기
        hanoi(n-1,temp,start,end);
    }
}