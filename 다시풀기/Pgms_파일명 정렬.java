import java.util.*;

class Solution {
    public String[] solution(String[] files) {
        int size = files.length;
        String[] answer = new String[size];
        
        PriorityQueue<File> pq = new PriorityQueue<>();
        
        for(int i=0;i<files.length;i++){
            pq.offer(new File(files[i],i));
        }
        
        for(int i=0;i<size;i++){
            answer[i] = pq.poll().str;
        }
        return answer;
    }
    
    static class File implements Comparable<File>{
        String str;
        int index;
        public File(String str, int index){
            this.str=str;
            this.index=index;
        }
        public int compareTo(File o){
            String temp = this.str;
            temp = temp.toLowerCase();
            String temp2 = o.str;
            temp2 = temp2.toLowerCase();
            
            String head1 ="";
            String head2 ="";
            String number1="";
            String number2="";
            
            boolean flag1=false;
            boolean flag2=false;
            for(int i=0;i<temp.length();i++){
                char c= temp.charAt(i);
                if(c-'0'>=0 && c-'0'<=9){
                    number1+=c+"";
                    flag1=true;
                }else if(flag1){
                    break;
                }else if(!flag1){
                    head1+=c+"";
                }
                
            }
            
            for(int i=0;i<temp2.length();i++){
                char c= temp2.charAt(i);
                if(c-'0'>=0 && c-'0'<=9){
                    number2+=c+"";
                    flag2=true;
                }else if(flag2){
                    break;
                }else if(!flag2){
                    head2+=c+"";
                }
            }
            
            if(head1.equals(head2)){
                int num1 = Integer.parseInt(number1);
                int num2 = Integer.parseInt(number2);
                if(num1==num2){
                    return this.index-o.index;
                }
                return num1-num2;
            }
            return head1.compareTo(head2);
        }
    }
}