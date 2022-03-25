import java.util.*;

class Solution {
    public String solution(int n, int k, String[] cmd) {
        String answer = "";
        
        int index = k;
        int cnt=n;
        List<Integer> list1 = new ArrayList<>();        //+된 인덱스
        List<Integer> list2 = new ArrayList<>();        //-된 인덱스
        Stack<Integer> stack = new Stack<>();       //삭제된거 저장해놓을 자료구조
        
        for(int i=0;i<cmd.length;i++){
            String[] command = cmd[i].split(" ");
            
            char c = command[0].charAt(0);
            int move=-1;
            switch(c){
                case 'U':
                    move = Integer.parseInt(command[1]);
                    index-=move;
                    break;
                case 'D':
                    move = Integer.parseInt(command[1]);
                    index+=move;
                    break;
                case 'C':
                    stack.push(index);
                    cnt-=1;
                    list1.add(index);
                    if(index==cnt){
                        index--;
                    }
                    break;
                case 'Z':
                    int num = stack.pop();
                    list2.add(num);
                    if(num<=index){
                        index++;
                    }
                    cnt+=1;
                    break;
            }
        }
        //System.out.println(index);
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<cnt;i++){
            sb.append("O");
        } 
        while(!stack.isEmpty()){
            int a = stack.pop();
            
            sb.insert(a,"X");
        }
        answer = sb.toString();
        
        return answer;
    }
    
}