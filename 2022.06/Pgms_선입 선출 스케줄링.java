import java.util.*;

class Solution {
    public int solution(int n, int[] cores) {
        int answer = 0;
        
        //이분탐색으로 시간부터 알아내자
        int size = cores.length;
        if(n<=size) return n;
        n-=size;
        
        int time =0;
        
        int start=1;
        int end = cores[0]*n;       //cores의 어떤 값이더라도 작업개수 곱해준 시간 안에 끝남.
        
        while(start<=end){
            int mid = (start+end)/2;
            
            int sum=0;
            for(int i=0;i<size;i++){
                sum+=mid/cores[i];
            }
            
            if(sum>=n){
                end=mid-1;
                time=mid;
                
            }else{
                start=mid+1;
            } 
        }
        
        int count = 0;
        for(int i=0;i<size;i++){
            count+= time/cores[i];
        }
        
        int diff = count-n;
        
        for(int i=size-1;i>=0;i--){
            if(time%cores[i]==0){
                if(diff==0) return i+1;
                diff--;
            }
        }
        
        return answer;
    }
}