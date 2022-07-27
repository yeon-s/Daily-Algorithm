import java.util.*;

class Solution {
    public int[] solution(int n, long k) {
        int[] answer = new int[n];
        
        List<Integer> list = new ArrayList<>();
        long[] arr = new long[n+1];
        arr[1]=1;
        for(int i=1;i<=n;i++){
            list.add(i);
            if(i>1) arr[i] = i*arr[i-1];
        }
        k--;
        
        int temp = n;
        for(int i=0;i<temp;i++){
            long num = arr[n]/n;
            int moc = (int)(k/num);
            k %= num;
            answer[i] = list.get(moc);
            list.remove(moc);
            n--;
        }
        
        return answer;
    }
}