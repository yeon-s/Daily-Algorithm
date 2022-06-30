import java.util.*;

class Solution {
    static List<Num> temp;
    public long solution(String expression) {
        long answer = 0;
        
        String[] arr = expression.split("\\+|\\-|\\*");
        List<Character> cal = new ArrayList<>();
        for(int i=0;i<expression.length();i++){
            char c = expression.charAt(i);
            if(c=='+' || c=='-' || c=='*') cal.add(c); 
        }
        
        List<Num> list = new ArrayList<>();
        list.add(new Num('c',Long.parseLong(arr[0])));
        for(int i=0;i<cal.size();i++){
            list.add(new Num(cal.get(i),Long.parseLong(arr[i+1])));
        }
        
        String[] priority = new String[]{"+-*","+*-","-+*","-*+","*+-","*-+"};
        for(int i=0;i<6;i++){
            //리스트 복사
            long result =0;
            temp = new ArrayList<>();
            for(int j=0;j<list.size();j++){
                temp.add(new Num(list.get(j).c,list.get(j).num));
            }
            String str = priority[i];
            char one = str.charAt(0);
            char two = str.charAt(1);
            char three = str.charAt(2);
            //계산 해보기
            func(one);
            func(two);
            func(three);
            
            result = Math.abs(temp.get(0).num);
            answer = Math.max(answer,result);
        }
        
        return answer;
    }
    
    static void func(char cc){
        for(int j=1;j<temp.size();j++){
            char c = temp.get(j).c;
            if(c==cc) {
                long num = calculate(c,temp.get(j-1).num,temp.get(j).num);
                temp.get(j-1).num=num;
                temp.remove(j);
                j--;
            }

        }
    }
    
    static long calculate(char c, long front, long end){
        if(c=='-') return front-end;
        else if(c=='+') return front+end;
        else return front*end;
    }
    
    static class Num{
        char c;     //내 앞의 연산자
        long num;
        public Num(char c,long num){
            this.c=c;
            this.num=num;
        }
        
    }
}