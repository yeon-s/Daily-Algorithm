import java.util.*;

class Solution {
    public int solution(int[] a) {
        int answer = 0;
        
        int size = a.length;
        int min = Integer.MAX_VALUE;
        int minIndex =0;
        
        for(int i=0;i<a.length;i++){
            if(min>a[i]){
                min=a[i];
                minIndex=i;
            }
        }
        
        if(size==1){
            return 1;
        }else if(size==2){
            return 2;
        }
        
        int[] D = new int[size];
        D[0]=a[0];
        D[size-1]=a[size-1];
        D[minIndex] = min;
        
        if(minIndex==0){
            for(int i=size-2;i>minIndex;i--){
                D[i] = Math.min(a[i],D[i+1]);
            }   

        }else if(minIndex==size-1){
            for(int i=1;i<minIndex;i++){
                D[i] = Math.min(D[i-1],a[i]);
            }
            
        }else{
            for(int i=1;i<minIndex;i++){
                D[i] = Math.min(D[i-1],a[i]);
            }
            for(int i=size-2;i>minIndex;i--){
                D[i] = Math.min(a[i],D[i+1]);
            }    
        }
        
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<size;i++){
            map.put(D[i],0);
        }
        answer=map.size();
        return answer;
    }
}