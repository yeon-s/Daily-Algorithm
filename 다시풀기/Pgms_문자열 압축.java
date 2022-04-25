class Solution {
    public int solution(String s) {
        int answer = s.length();
        
        int size= 1;
        while(true){
            int check = s.length();
            int cnt=1;
            String str = s.substring(0,size);
            for(int i=size;i<s.length();i++){
                if(i+size>s.length()){
                    break;
                }
                
                String temp = s.substring(i,i+size);
                if(str.equals(temp)){
                    check-=size;
                    cnt++;
                }else{
                    str=temp;
                    if(cnt>1){
                        if(cnt>=1000){
                            check+=4;
                        }else if(cnt>=100){
                            check+=3;
                        }else if(cnt>=10){
                            check+=2;
                        }else{
                            check+=1;
                        }
                        cnt=1;
                    }
                }
                i+=size-1;
            }
            if(cnt>1){
                if(cnt>=1000){
                    check+=4;
                }else if(cnt>=100){
                    check+=3;
                }else if(cnt>=10){
                    check+=2;
                }else{
                    check+=1;
                }
                cnt=1;
            }
            answer = Math.min(check,answer);
            size++;
            if(size*2>s.length()){
                break;
            }
        }
        return answer;
    }
}