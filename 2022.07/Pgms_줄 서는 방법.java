class Solution {
    static boolean[] isSelected;
    static int[] answer;
    static int index,N;
    
    public int[] solution(int n, long k) {
        answer = new int[n];
        
        long[] arr = new long[n+1];
        isSelected = new boolean[n+1];
        N=n;
        
        arr[1]=1;
        for(int i=2;i<=n;i++){
            arr[i] = i*arr[i-1];
        }
        
        index=0;
        while(n>1){
            long num = arr[n]/n;
            int moc = (int)(k/num);
            long nam = k%num;
            
            //System.out.println(moc+" "+nam);
            
            if(nam==0){
                int col = find(moc);
                answer[index++] = col;
                isSelected[col]=true;
                findReverse();
                break;
            }
            k=nam;
            int col = find(moc+1);
            answer[index++]= col;
            isSelected[col]=true;
            n--;
        }
        
        return answer;
    }
    
    static int find(int cnt){
        
        int temp=1;
        for(int i=1;i<=N;i++){
            if(isSelected[i]){
                continue;
            }
            if(temp==cnt) return i;
            temp++;
        }
        return 0;
    }
    
    static void findReverse(){
        for(int i=N;i>=1;i--){
            if(!isSelected[i]){
                answer[index++] = i;
            }
        }
    }
}