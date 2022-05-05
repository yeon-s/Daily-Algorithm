class Solution {
    static int[] temp;
    static int size;
    public int solution(int[] stones, int k) {
        int answer = 0;
        
        size = stones.length;
        int start = 0;
        int end = 200000000;
        
        while(start<=end){
            int mid = (start+end)/2;
            
            temp = new int[size];
            make(mid,stones);
            
            //슬라이딩 윈도우로 연속 k개 0인게 있는지 확인
            if(check(k)){
                end = mid-1;
            }else{
                start = mid+1;
                answer = mid;
            }
        }
        return answer+1;        //연속 k개가 0이 아닌 최대값에서 한명은 더 갈 수 있음
    }
    
    static void make(int mid, int[] stones){
        for(int i=0;i<size;i++){
            temp[i]=stones[i]-mid;
            if(temp[i]<0) temp[i]=0;
        }
    }
    
    static boolean check(int k){
        
        int sum=0;
        for(int i=0;i<k;i++){
            sum+=temp[i];
        }
        
        if(sum==0){
            return true;
        }
        for(int i=1;i<=size-k;i++){
            sum+=temp[i+k-1];
            sum-=temp[i-1];
            
            if(sum==0){
                return true;
            }
        }
        return false;
    }
}