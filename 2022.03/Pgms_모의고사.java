import java.util.*;

class Solution {
    public List<Integer> solution(int[] answers) {
        int[] answer = new int[4];
        List<Integer> list = new ArrayList<>();
        int size= answers.length;
        int[] one = new int[size];
        for(int i=0;i<size;i++){
            one[i] = (i%5)+1;
        }
        
        int[] two = new int[size];
        int num=1;
        for(int i=0;i<size;i++){
            if(i%2==0){
                two[i]=2;
                continue;
            }
            two[i]=num;
            num++;
            if(num==2){
                num=3;
            }
            if(num==6){
                num=1;
            }
        }
        
        int[] three = new int[size];
        
        for(int i=0;i<size;i++){
            num = i%10;
            if(num==0 || num==1){
                three[i]=3;
            }else if(num==2 || num==3){
                three[i]=1;
            }else if(num==4 || num==5){
                three[i]=2;
            }else if(num==6 || num==7){
                three[i]=4;
            }else if(num==8 || num==9){
                three[i]=5;
            }
        }
        
        for(int i=0;i<size;i++){
            num = answers[i];
            if(num==one[i]) answer[1]++;
            if(num==two[i]) answer[2]++;
            if(num==three[i]) answer[3]++;
        }
        
        int max = 0;
        for(int i=1;i<4;i++){
            if(max<answer[i]){
                max = answer[i];
            }
        }
        
        for(int i=1;i<4;i++){
            if(answer[i]==max){
                list.add(i);
            }
        }
        
        return list;
    }
}