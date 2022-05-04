class Solution {
    public int solution(String dartResult) {
        int answer = 0;
        
        int[] score = new int[3];
        int[] bonus = new int[3];
        int[] option = new int[3];
        
        int index=0;
        for(int i=0;i<dartResult.length();i++){
            char c= dartResult.charAt(i);
            if(c-'0'>=0 && c-'0'<=9){
                if(c=='1' && i+1<dartResult.length() && dartResult.charAt(i+1)=='0'){
                    score[index]=10;
                    i++;
                    continue;
                }
                score[index]=c-'0';
            }else if(c=='S' || c=='D' || c=='T'){
                if(c=='S'){
                    bonus[index]=1;   
                }else if(c=='D'){
                    bonus[index]=2;
                }else if(c=='T'){
                    bonus[index]=3;
                }
                
                if(i+1<dartResult.length()){
                    if(dartResult.charAt(i+1)!='#' && dartResult.charAt(i+1)!='*'){
                        index++;
                    }
                }
            }else if(c=='*' || c=='#'){
                if(c=='*'){
                    option[index]=2;
                }else{
                    option[index]=-1;
                }
                index++;
            }
            
        }
        
        for(int i=1;i<=2;i++){
            if(option[i]==2){
                if(option[i-1]==0){
                    option[i-1]=2;
                }else{
                    option[i-1]*=2;
                }
            }
        }
        
        for(int i=0;i<3;i++){
            if(option[i]==0){
                answer += Math.pow(score[i],bonus[i]);
            }else{
                answer += Math.pow(score[i],bonus[i])*option[i];
            }
        }
        return answer;
    }
}