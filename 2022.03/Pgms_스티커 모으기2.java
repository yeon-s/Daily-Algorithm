class Solution {
    public int solution(int sticker[]) {
        int answer = 0;

        int size = sticker.length;
        for(int k=0;k<2;k++){       //k=0은 처음을 뽑은 경우, k=1은 처음 안뽑은 경우
            int[] D = new int[size+1];
            if(k==0 || size==1){
                D[1] = sticker[0];
            }
            
            for(int i=2;i<size+1;i++){
                if(k==0 && i==size){
                    break;
                }
                D[i] = Math.max(D[i-2]+sticker[i-1],D[i-1]);
            }
            if(k==0){
                D[size] = D[size-1];
            }
            
            answer = Math.max(answer,D[size]);
            
        }

        return answer;
    }
}