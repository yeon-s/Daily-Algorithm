import java.util.*;

class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        
        int[][] map1 = new int[n][n];
        int[][] map2 = new int[n][n];
        
        fill(map1,n,arr1);
        fill(map2,n,arr2);
        
        for(int i=0;i<n;i++){
            String temp ="";
            for(int j=0;j<n;j++){
                char c = (map1[i][j] | map2[i][j])==1 ? '#':' ';
                temp+=c+"";
            }
            
            answer[i]=temp;
        }
        
        return answer;
    }
    
    static void fill(int[][] map, int n,int[] arr){
        for(int i=0;i<n;i++){
            String str = change(arr[i]);
            int length = str.length();
            for(int j=n-length;j<n;j++){
                map[i][j] = str.charAt(j-n+length)-'0';
            }    
        }
    }
    
    static String change(int num){
        return Integer.toString(num,2);
    }
}