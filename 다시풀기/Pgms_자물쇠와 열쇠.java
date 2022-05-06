import java.util.*;

class Solution {
    static int[][] Key;
    static int[][] map;
    static int n;
    static int m;
    public boolean solution(int[][] key, int[][] lock) {
        boolean answer = false;
        
        n = lock.length;
        m = key.length;
        
        Key = key;
        map = new int[n+(2*m)-2][n+(2*m)-2];
        
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                map[m-1+i][m-1+j] = lock[i][j];
            }
        }
        
        if(check()){
            answer =true;
        }
        return answer;
    }
    
    static void rotate(int d){
        if(d==0){
            return;
        }
        
        int[][] temp = new int[m][m];
        
        for(int i=0;i<m;i++){
            for(int j=0;j<m;j++){
                temp[j][m-1-i] = Key[i][j];
            }
        }
        Key = temp;
    }
    
    static boolean check(){
        
        for(int d=0;d<4;d++){
            rotate(d);      //열쇠 회전
            
            for(int i=0;i<=n+m-2;i++){
                for(int j=0;j<=n+m-2;j++){
                    int[][] temp = copy();
                    
                    if(add(i,j,temp)){
                        return true;
                    }
                }
            }
        }
        return false;
    }
    
    static boolean add(int si,int sj,int[][] temp){
        for(int i=si;i<si+m;i++){
            for(int j=sj;j<sj+m;j++){
                temp[i][j]+=Key[i-si][j-sj];
            }
        }
        
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(temp[m-1+i][m-1+j]!=1){
                    return false;
                }
            }
        }
        return true;
    }
    
    static int[][] copy(){
        int[][] temp = new int[n+(2*m)-2][n+(2*m)-2];
        int size = temp.length;
        for(int i=0;i<size;i++){
            for(int j=0;j<size;j++){
                temp[i][j] = map[i][j];
            }
        }
        return temp;
    }
}