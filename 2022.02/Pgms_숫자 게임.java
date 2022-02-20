import java.util.*;

class Solution {
    public int solution(int[] A, int[] B) {
        int answer = 0;
        
        List<Integer> listA = new ArrayList<>();
        List<Integer> listB = new ArrayList<>();
        
        Arrays.sort(A);
        Arrays.sort(B);
        
        for(int i=0;i<A.length;i++){
            listA.add(A[i]);
            listB.add(B[i]);
        }
        
        int size = A.length;
        int indexA=0;
        int indexB=0;
        
        while(indexA<size){
            
            if(listA.get(indexA)>=listB.get(indexB)){
                listA.remove(listA.size()-1);
                size--;
                indexB++;
            }else{
                indexA++;
                indexB++;
                answer++;
            }
        }
        
        return answer;
    }
}