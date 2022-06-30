class Solution {
    public String solution(int n, int t, int m, int p) {
        String answer = "";
        
        String str= "";
        for(int i=0;i<30000;i++){
            String temp = Integer.toString(i,n);
            str+=temp;
            if(str.length()>t*m+p) break;
        }
        str=str.toUpperCase();
        
        for(int i=0;i<t;i++){
            char c = str.charAt((i*m)+p-1);
            answer+=c+"";
        }
        return answer;
    }
}