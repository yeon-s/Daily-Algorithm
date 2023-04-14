class Solution {
    static int size;
    static boolean[] isSelected;
    static int[][] Dungeons;
    static int max;
    public int solution(int k, int[][] dungeons) {
       
        size = dungeons.length;
        isSelected = new boolean[size];
        Dungeons = dungeons;
        
        max=0;
        perm(0,k,0);
        return max;
    }
    
    static void perm(int cnt,int now,int num){
        if(cnt==size){
            max=Math.max(max,num);
            return;
        }
        
        for(int i=0;i<size;i++){
            if(isSelected[i]) continue;
            
            isSelected[i]=true;
            if(now>=Dungeons[i][0]){
                perm(cnt+1,now-Dungeons[i][1],num+1);
            }else{
                perm(cnt+1,now,num);
            }
            isSelected[i]=false;
        }
        
    }
}
