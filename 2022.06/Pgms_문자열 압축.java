class Solution {
    public int solution(String s) {
        int size = s.length();
        int answer = size;
        for(int i=1;i<=size/2;i++){
            int result=size;
            int cnt = 1;
            int index=i;
            //예외처리 필요
            String str = s.substring(0,i);
            while(index+i<=size){
                String temp = s.substring(index,index+i);
                if(str.equals(temp)){
                    cnt++;
                    result-=i;
                }else{
                    str=temp;
                    if(cnt>1){
                        String number = cnt+"";
                        result+=number.length();
                    }
                    cnt=1;
                }
                index+=i;
            }
            // cnt 체크
            if(cnt>1){
                String number = cnt+"";
                result+=number.length();
            }
            answer = Math.min(answer,result);
        }
        return answer;
    }
}