class Solution {
    static char[] arr;
    static boolean[] isSelected;
    static char[] result;
    static int N;
    static String[] Data;
    static int answer;
    public int solution(int n, String[] data) {
        answer = 0;
        
        arr = new char[]{'A','C','F','J','M','N','R','T'};
        isSelected = new boolean[8];
        result = new char[8];
        N=n;
        Data=data;
        
        perm(0);
        
        return answer;
    }
    
    static void perm(int cnt){
        if(cnt==8){
            
            for(int i=0;i<N;i++){
                String str = Data[i];
                char c1 = str.charAt(0);
                char c2 = str.charAt(2);
                
                int index1=0,index2=0;
                for(int j=0;j<8;j++){
                    if(result[j]==c1) index1=j;
                    if(result[j]==c2) index2=j;
                }
                
                char con = str.charAt(3);
                int diff = str.charAt(4)-'0';
                int num = Math.abs(index1-index2)-1;
                
                if(con=='='){
                    if(num!=diff) return;
                }else if(con=='>'){
                    if(num<=diff) return;
                }else{
                    if(num>=diff) return;
                }
            }
            answer++;
            return;
        }
        
        for(int i=0;i<8;i++){
            if(isSelected[i]) continue;
            
            result[cnt]=arr[i];
            isSelected[i]=true;
            perm(cnt+1);
            isSelected[i]=false;
        }
    }
}