import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        int[] answer = new int[3];
        int size = answers.length;
        
        int[] one = new int[size];
        int[] two = new int[size];
        int[] three = new int[size];
        
        for(int i=0;i<size;i++){
            one[i] = i%5+1;
        }
        
        int num=1;
        for(int i=0;i<size;i++){
            if(i%2==0) {
                two[i]=2;
            } else{
                two[i]=num++;
                if(num==2) num++;
                if(num>5) num=1;
            }
        }
        
        int[] arr = {3,3,1,1,2,2,4,4,5,5};
        for(int i=0;i<size;i++){
            three[i] = arr[i%10];
        }
        
        for(int i=0;i<size;i++){
            if(answers[i]==one[i])   answer[0]++;
            if(answers[i]==two[i])   answer[1]++;
            if(answers[i]==three[i])   answer[2]++;
        }
        
        List<Integer> list = new ArrayList<>();
        int max = Math.max(answer[0],answer[1]);
        max = Math.max(max, answer[2]);
        
        for(int i=0;i<3;i++){
            if(answer[i]==max) list.add(i+1);
        }
        answer = new int[list.size()];
        for(int i=0;i<list.size();i++){
            answer[i] = list.get(i);
        }
        return answer;
    }
}
