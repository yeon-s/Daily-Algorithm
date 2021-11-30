package practice;

import java.util.*;

class Solution2 {
    static char[][] map;
    public int solution(String[] cakes, int[] cut_rows, int[] cut_columns) {
        int answer = 0;
        
        int size = cakes.length;
        map = new char[size][size];
        
        for(int i=0;i<size;i++){
            String str = cakes[i];
            for(int j=0;j<size;j++){
                map[i][j] = str.charAt(j);
            }
        }
        //입력 끝
        
        int row = cut_rows.length;
        int column = cut_columns.length;
        
        //0추가 해주기
        int[] cutRows = new int[row+2];
        int[] cutColumns = new int[column+2];
        cutRows[0]=0;
        for(int i=0;i<row;i++){
            cutRows[i+1]=cut_rows[i];
        }
        cutRows[cutRows.length-1] =size;
        
        cutColumns[0]=0;
        for(int i=0;i<column;i++){
             cutColumns[i+1]=cut_columns[i];
        }
        cutColumns[cutColumns.length-1]=size;
            
        for(int i=0;i<cutRows.length-1;i++){
            for(int j=0;j<cutColumns.length-1;j++){
                int tasteNum = count(cutRows[i],cutRows[i+1],
                                cutColumns[j],cutColumns[j+1]);
                answer=Math.max(answer,tasteNum);
            }
        }
        
        return answer;
    }
    
    static int count(int si,int ei,int sj,int ej){
       //StringBuilder sb = new StringBuilder();
        String str = "";
        for(int i=si;i<ei;i++){
            for(int j=sj;j<ej;j++){
                char taste = map[i][j];
                if(str.contains(taste+"")){
                    continue;
                }else{
                   str= str+(taste+"");
                }
            }
        }
        return str.length();
    }
}