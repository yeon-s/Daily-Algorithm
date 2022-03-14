import java.util.*;

class Solution
{
    public int solution(int []A, int []B)
    {
        int answer = 0;

        Arrays.sort(A);
        // Arrays.sort(B,new Comparator<Integer>(){
        //     public int compare(Integer o1, Integer o2){
        //         return o2-o1;
        //     }
        // });
        Arrays.sort(B);
        
        for(int i=0;i<A.length;i++){
            answer+=(A[i]*B[A.length-1-i]);
        }

        return answer;
    }
}