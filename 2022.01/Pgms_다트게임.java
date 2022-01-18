import java.util.*;

class Solution {
    public int solution(String dartResult) {
        int answer = 0;
        
        
        int size = dartResult.length();
        int[] score = new int[3];
        String[] option = new String[3];
        for(int i=0;i<3;i++){
            option[i]="";
        }
        
        int tern=0;
        for(int i=0;i<size;i++){
            int num = Integer.parseInt(dartResult.substring(i,i+1));
            if(i+1<size && dartResult.substring(i+1,i+2).equals("0")){
                num=10;
                i++;
            }
            i++;
            String str = dartResult.substring(i,i+1);
            if(str.equals("T")){
                num *= num*num;
            }else if(str.equals("D")){
                num *= num;
            }
            
            score[tern]=num;
            
            if(i+1<size && (dartResult.substring(i+1,i+2).equals("*") || 
                            dartResult.substring(i+1,i+2).equals("#") )){
                i++;
                if(dartResult.substring(i,i+1).equals("*")){
                    option[tern] +="*";
                    if(tern-1>=0){
                        option[tern-1] +="*";
                    }
                }else{
                    option[tern] +="#";
                }
            }
            tern++;            
        }
        
        for(int i=0;i<3;i++){
            int number = score[i];
            String what = option[i];
            if(what.equals("*")){
                answer+=(number*2);
            }else if(what.equals("#")){
                answer-=number;
            }else if(what.equals("#*")){
                answer-=(number*2);
            }else if(what.equals("**")){
                answer+=(number*4);
            }else{
                answer+=number;
            }
        }
        
        return answer;
    }
}