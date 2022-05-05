import java.util.*;

//에라토스테네스의 체는 해당범위까지 모든 소수를 구해야해서 오래걸리지만
//이 문제는 변환했을때 나오는 숫자가 많지 않다. 자릿수로보니까 많아야 열개?
//그래서 각각 소수인지 확인해주는 게 훨씬 빠르다..

class Solution {
    static boolean[] sosu;
    public int solution(int n, int k) {
        int answer = 0;
        
        String str = Integer.toString(n,k);
        String[] arr = str.split("0",-1);
        
        //findSosu();
        
        for(int i=0;i<arr.length;i++){
            if(arr[i].equals("") || arr[i].equals("1")){
                continue;
            }
            long number = Long.parseLong(arr[i]);
            
            int num=(int)Math.sqrt(number);
            num+=1;
            boolean flag=false;
            for(int j=2;j<num;j++){
                if(number%j==0){
                    flag=true;
                    break;
                }
            }
            if(!flag){
                answer++;
            }
            
            // if(!sosu[(int)number]){
            //     answer++;
            // }
        }
        
        return answer;
    }
    
    static void findSosu(){
        int num = 100000000;
        sosu = new boolean[num];
        for(int i=2;i*i<num;i++){
            if(sosu[i]){
                continue;
            }
            for(int j=i*i;j<num;j+=i){
                sosu[j]=true;
            }
        }
    }
}