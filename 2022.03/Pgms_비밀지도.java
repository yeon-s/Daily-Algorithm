import java.util.*;

class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        
        int[][] map1 = new int[n][n];
        int[][] map2 = new int[n][n];
        
        for(int i=0;i<arr1.length;i++){
            int num = arr1[i];
            for(int j=n-1;j>=0;j--){
                map1[i][j] = num%2;
                if(num/2!=0){
                    num/=2;
                }else{
                    break;
                }
            }
        }
        
        for(int i=0;i<arr2.length;i++){
            int num = arr2[i];
            for(int j=n-1;j>=0;j--){
                map2[i][j] = num%2;
                if(num/2!=0){
                    num/=2;
                }else{
                    break;
                }
            }
        }
        
        for(int i=0;i<n;i++){
            String str = "";
            for(int j=0;j<n;j++){
                if(map1[i][j]==1 || map2[i][j]==1){
                    str+="#";
                }else{
                    str+=" ";
                }
            }
            answer[i]=str;
        }
        return answer;
    }
}