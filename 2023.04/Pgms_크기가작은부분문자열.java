class Solution {
    public int solution(String t, String p) {
        int answer = 0;
        int size = p.length();
        
        for(int i=0;i<=t.length()-size;i++){
            String str = t.substring(i,i+size);
            
            if(Long.parseLong(p)>=Long.parseLong(str)) answer++;
        }
        return answer;
    }
}
