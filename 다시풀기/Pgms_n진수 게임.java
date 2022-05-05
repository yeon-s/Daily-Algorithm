class Solution {
    public String solution(int n, int t, int m, int p) {
        String answer = "";
        
        StringBuilder sb = new StringBuilder();
        
        int num = 0;
        while(true){
            String temp = Integer.toString(num,n);
            temp = temp.toUpperCase();
            sb.append(temp);
            
            if(sb.length()>t*m){
                break;
            }
            num++;
        }
        
        String str = sb+"";
        int index=p-1;
        while(t-->0){
            char c = str.charAt(index);
            answer+=c+"";
            
            index+=m;
        }
        
        return answer;
    }
}