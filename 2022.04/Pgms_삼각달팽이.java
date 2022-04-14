import java.util.*;

class Solution {
    public List<Integer> solution(int n) {
        List<Integer> answer = new ArrayList<>();
        
        int[][] map = new int[n][n];
        int cnt= n;
        int i=-1;
        int j=0;
        int num=0;
        int number=1;
        while(cnt>0){
            int temp=cnt;
            if(num%3==0){
                j=num/3;
                while(temp-->0){
                    map[++i][j]=number++;
                }
            }else if(num%3==1){
                while(temp-->0){
                    map[i][++j]=number++;
                }
            }else{
                while(temp-->0){
                    map[--i][--j]=number++;
                }
            }
            
            cnt--;
            num++;
        }
        
        for(int q=0;q<n;q++){
            for(int w=0;w<n;w++){
                if(map[q][w]==0){
                    break;
                }
                answer.add(map[q][w]);
            }
        }
        
        
        return answer;
    }
}