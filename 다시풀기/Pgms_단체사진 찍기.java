import java.util.*;

class Solution {
    
    static boolean[] isSelected;
    static String[] result;
    static String[] Data;
    static String[] arr;
    static int answer;
    public int solution(int n, String[] data) {
        answer = 0;
        
        arr = new String[]{"A", "C", "F", "J", "M", "N", "R", "T"};
        isSelected = new boolean[8];
        result = new String[8];
        Data = data;
        
        perm(0);
        return answer;
    }
    
    static void perm(int cnt){
        if(cnt==8){
            //조건 확인
            
            for(int i=0;i<Data.length;i++){
                char a = Data[i].charAt(0);
                char b = Data[i].charAt(2);
                char check = Data[i].charAt(3);
                int num = Data[i].charAt(4)-'0';
                
                int anum = 0;
                int bnum = 0;
                for(int j=0;j<8;j++){
                    if(result[j].charAt(0)==a){
                        anum=j;
                    }
                    if(result[j].charAt(0)==b){
                        bnum=j;
                    }
                }
                
                if(check=='>'){
                    if((int)(Math.abs(anum-bnum))-1<=num){
                        return;
                    }
                }else if(check=='<'){
                    if((int)(Math.abs(anum-bnum))-1>=num){
                        return;
                    }
                }else if(check=='='){
                    if((int)(Math.abs(anum-bnum))-1!=num){
                        return;
                    }
                }
            }
            answer++;
            
            return;
        }    
        
        for(int i=0;i<8;i++){
            if(isSelected[i]){
                continue;
            }
            
            result[cnt] = arr[i];
            isSelected[i]=true;
            perm(cnt+1);
            isSelected[i]=false;
        }
    }
}