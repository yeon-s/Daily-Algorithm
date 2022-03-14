class Solution {
    
    static int N;
    static int[] result;
    static int max;
    static int[] Info;
    static int[] answer;
    public int[] solution(int n, int[] info) {
        answer = new int[11];
        
        N=n;
        result = new int[11];
        Info = info;
        max=0;
        comb(0,0);
        if(max==0){
           answer = new int[1];
           answer[0]=-1;
        }
        return answer;
    }
    
    static void comb(int cnt,int start){
        if(cnt==N){
            int lion =0;
            int appeach =0;
            
            for(int i=0;i<=10;i++){
                if(Info[10-i]==0 && result[i]==0){
                    continue;
                }
                if(Info[10-i]>=result[i]){
                    appeach+=i;
                }else{
                    lion+=i;
                }
            }
            
            if(lion>appeach){
                if(lion-appeach>max){
                    max= lion-appeach;
                    for(int i=0;i<=10;i++){
                        answer[i]=result[10-i];
                    }
                }
            }
            return;
        }
        
        for(int i=start;i<=10;i++){
            result[i]++;
            comb(cnt+1,i);
            result[i]--;
        }
    }
}