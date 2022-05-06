class Solution {
    public int solution(String s) {
        int answer = 0;
        
        String[] arr = new String[]{"zero","one","two","three","four","five","six","seven","eight","nine"};
        
        for(int i=0;i<10;i++){
            if(s.contains(arr[i])){
                s=s.replace(arr[i],i+"");
            }
        }
        answer = Integer.parseInt(s);
        return answer;
    }
}