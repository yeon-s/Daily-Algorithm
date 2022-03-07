import java.util.*;

class Solution {

    public long solution(int n, int m, int x, int y, int[][] queries) {
        long answer = 0;
        
        long rowStart = x;
        long rowEnd = x;
        long colStart=y;
        long colEnd =y;
        
        for(int i=queries.length-1;i>=0;i--){
            int commandD = queries[i][0];
            int commandCnt = queries[i][1];
            
            if(commandD==0){
                if(colStart!=0){
                    colStart+=commandCnt;
                }
                colEnd +=commandCnt;
                if(colEnd>m-1){
                    colEnd=m-1;
                }
            }else if(commandD==1){
                if(colEnd!=m-1){
                    colEnd-=commandCnt;
                }
                colStart-=commandCnt;
                if(colStart<0){
                    colStart=0;
                }
            }else if(commandD==2){
                if(rowStart!=0){
                    rowStart+=commandCnt;
                }
                rowEnd+=commandCnt;
                if(rowEnd>n-1){
                    rowEnd=n-1;
                }
            }else if(commandD==3){
                if(rowEnd!=n-1){
                    rowEnd-=commandCnt;
                }
                rowStart-=commandCnt;
                if(rowStart<0){
                    rowStart=0;
                }
            }
            
            if(rowStart>=n || rowEnd<0 || colStart>=m || colEnd<0){
                return answer;
            }
        }
        answer = (rowEnd-rowStart+1)*(colEnd-colStart+1);
       
        return answer;
    }
    
}