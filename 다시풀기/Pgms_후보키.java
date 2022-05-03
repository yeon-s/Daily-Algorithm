import java.util.*;

class Solution {
    static int col;
    static boolean[] isSelected;
    static int size;
    static String[][] Relation;
    static Map<List<Integer>,Integer> hubo;
    public int solution(String[][] relation) {
        int answer = 0;
        
        size = relation.length;         //튜플 개수
        col = relation[0].length;       //컬럼의 개수
        isSelected = new boolean[col];
        Relation = relation;
        hubo = new HashMap<>();
        //부분집합하고 map
        
        subset(0);
        
        answer = hubo.size();
        return answer;
    }
    
    static void subset(int cnt){
        if(cnt==col){
            
            check();        //유일성 체크
            return;
        }
        
        isSelected[cnt]=false;
        subset(cnt+1);
        isSelected[cnt]=true;
        subset(cnt+1);
    }
    
    static void check(){
        
        Map<String,Integer> map = new HashMap<>();
        StringBuilder sb;
        for(int i=0;i<size;i++){
            sb = new StringBuilder();
            for(int j=0;j<col;j++){
                if(isSelected[j]){
                    sb.append(Relation[i][j]+" ");
                }
            }
            map.put(sb+"",1);
        }
        
        if(map.size()==size){
            List<Integer> list = new ArrayList<>();
            for(int i=0;i<col;i++){
                if(isSelected[i]){
                    list.add(i);
                }
            }
            
            for(List<Integer> l:hubo.keySet()){
                boolean flag=false;
                for(int i:l){
                    if(!list.contains(i)){
                        flag=true;
                        break;
                    }
                }
                if(!flag){
                    return;
                }
            }
            hubo.put(list,1);
        }
    }
}