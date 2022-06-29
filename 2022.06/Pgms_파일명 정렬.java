import java.util.*;

class Solution {
    public String[] solution(String[] files) {
        int size = files.length;
        String[] answer = new String[size];
        
        List<File> list = new ArrayList<>();
        
        for(int i=0;i<size;i++){
            String str = files[i];
            String head="";
            String number="";
            String tail="";
            char what = 'h';
            for(int j=0;j<str.length();j++){
                char c = str.charAt(j);
                if(what=='h'){
                    if(c-'0'>=0 && c-'9'<=0){  //현재가 숫자면
                        what = 'n';
                        number+=c+"";
                    }else{
                        head+=c+"";
                    }
                }else if(what=='n'){
                    if(c-'0'>=0 && c-'9'<=0){  //현재가 숫자면
                        number+=c+"";
                    }else{
                        what='t';
                        tail+=c+"";
                    }
                }else{
                    tail+=c+"";
                }
                
            }
            list.add(new File(head,number,tail,i));
        }
        
        Collections.sort(list);
        for(int i=0;i<size;i++){
            File f = list.get(i);
            String temp = "";
            temp =f.head+f.number+f.tail;
            answer[i]= temp;
        }
        return answer;
    }
    
    static class File implements Comparable<File>{
        String head;
        String number;
        String tail;
        int originIndex;
        public File(String head, String number, String tail, int originIndex){
            this.head= head;
            this.number=number;
            this.tail=tail;
            this.originIndex=originIndex;
        }
        public int compareTo(File o){
            String head1 = this.head.toLowerCase();
            String head2 = o.head.toLowerCase();
            if(head1.equals(head2)){
                int number1 = Integer.parseInt(this.number);
                int number2 = Integer.parseInt(o.number);
                if(number1==number2){
                    return this.originIndex-o.originIndex;
                }
                return number1-number2;
            }
            return head1.compareTo(head2);
        }
    }
}