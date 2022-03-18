class Solution {
    public int[] solution(long n) {
        String str = (n+"");
        int size = str.length();
        int[] answer = new int[size];
        
        int index=0;
        for(int i=size-1;i>=0;i--){
            answer[index++] = str.charAt(i)-'0';
        }
        
        return answer;
    }
}