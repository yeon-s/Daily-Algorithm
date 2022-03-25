import java.util.*;

class Solution {
    public String solution(int n, int k, String[] cmd) {
        String answer = "";
        
        LinkedList<Integer> list = new LinkedList<>();
        for(int i=0;i<n;i++){
            list.add(i);
        }
        
        int index = k;
        Stack<Number> stack = new Stack<>();       //삭제된거 저장해놓을 자료구조
        
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
                    stack.push(new Number(index,list.get(index)));
                    list.remove(index);
                    if(index==list.size()){
                        index--;
                    }
                    break;
                case 'Z':
                    Number num = stack.pop();
                    list.add(num.current,num.origin);
                    if(num.current<=index){
                        index++;
                    }
                    break;
            }
        }
        
        boolean[] arr = new boolean[n];
        for(int number:list){
            arr[number]=true;
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<n;i++){
            sb.append("O");
        }
        
        for(int i=0;i<n;i++){
            if(arr[i]==false){
                sb.replace(i,i+1,"X");
            }
        }
        
        answer = sb.toString();
        return answer;
    }
    
    static class Number{
        int current;
        int origin;
        public Number(int current,int origin){
            this.current = current;
            this.origin = origin;
        }
    }
}