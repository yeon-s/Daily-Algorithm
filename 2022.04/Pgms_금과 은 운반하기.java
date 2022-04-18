class Solution {
    public long solution(int a, int b, int[] g, int[] s, int[] w, int[] t) {
        long answer = (long)(1e9 * 2 * 1e5 *2);
        
        int size= t.length; //도시개수
        long start =0;
        long end = (long)(1e9 * 2 * 1e5 *2);
        
        while(start<=end){
            long mid = (start+end)/2;
            
            long gold =0;
            long silver =0;
            long sum=0;
            for(int i=0;i<size;i++){
                long cnt = ((mid/t[i])+1)/2;
                //cnt번 운반가능한데 금과 은 배분 어떻게 할지
                long available = cnt*w[i];       //운반가능무게
               
                gold+=Math.min(g[i],available);
                silver+=Math.min(s[i],available);
                sum+=Math.min(g[i]+s[i],available);
                
            }
            if(sum>=a+b && gold>=a && silver>=b){
                end=mid-1;
                answer=mid;
            }else{
                start=mid+1;
            }
        }
        return answer;
    }
}