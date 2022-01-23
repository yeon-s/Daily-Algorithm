import java.util.*;

class Solution {
    static String[][] map;
    static int n;
    static int count;
    public int[][] solution(int N, int[][] build_frame) {
        
        n=N;
        int size = build_frame.length;
        count=0;
        
        map = new String[n+1][n+1];
        for(int i=0;i<=n;i++){
            for(int j=0;j<=n;j++){
                map[i][j]="";
            }
        }
        
        int x,y,a,b;
        for(int i=0;i<size;i++){
            x = build_frame[i][0];
            y = build_frame[i][1];
            a = build_frame[i][2];
            b = build_frame[i][3];
            
            if(b==1){       //설치
                if(a==0){   //기둥
                    if(insertStick(x,y)){
                        map[x][y] += "0"; 
                        count++;
                    }
                }else{      //보
                    if(insertBo(x,y)){
                        map[x][y]+="1";
                        count++;
                    }                    
                }
            }else{          //삭제
                if(a==0){   //기둥
                    if(deleteStick(x,y)){
                        count--;   
                    }
                }else{      //보
                    if(deleteBo(x,y)){
                        count--;
                    }
                }
            }
        }
    
        int[][] answer = new int[count][3];
        int index=0;
        for(int j=0;j<=n;j++){
            for(int i=0;i<=n;i++){
                if(map[i][j].contains("0")){
                    answer[index][0]=i;
                    answer[index][1]=j;
                    answer[index][2]=0;
                    index++;
                }
                if(map[i][j].contains("1")){
                    answer[index][0]=i;
                    answer[index][1]=j;
                    answer[index][2]=1;
                    index++;
                }
            }
        }
        
        Arrays.sort(answer,new Comparator<int[]>(){
            public int compare(int[] o1, int[] o2){
                if(o1[0] != o2[0]){
                    return o1[0]-o2[0];
                }else{
                    return o1[1]-o2[1];
                }
            }
        });
        
        
        return answer;
    }
    
    static boolean insertStick(int x,int y){
        if(y==0){
            return true;
        }else{
            if( (x-1>=0 && map[x-1][y].contains("1")) || 
              (map[x][y].contains("1")) || (y-1>=0 && map[x][y-1].contains("0"))  ){
                return true;
            }else{
                return false;
            }
        }
    }
    
    static boolean insertBo(int x,int y){
        if((y-1>=0 && map[x][y-1].contains("0")) || (x+1<=n && map[x+1][y-1].contains("0")) ||
             (x-1>=0 && x+1<n && map[x-1][y].contains("1") && map[x+1][y].contains("1") )   ){
            return true;
        }else{
            return false;
        }
    }
    
    
    //내가 한 것처럼 보랑 기둥 지울 때 조건 다 따지면 빡구현이라 너무 힘들어서
    //그냥 지우고 전체 돌면서 지워도 되는지 보면된다.
    //힘들었는데...ㅠㅠ
    //////////////////
    static boolean delete(int x,int y){
        for(int i=0;i<=n;i++){
            for(int j=0;j<=n;j++){
                if(map[i][j].contains("0") && !insertStick(i,j)){
                    return false;
                }
                if(map[i][j].contains("1") && !insertBo(i,j)){
                    return false;
                }
            }
        }
        return true;
    }
    //////////////////////////
    
    static boolean deleteStick(int x,int y){
        
        if(map[x][y].contains("1")){
            map[x][y]="1";
        }else{
            map[x][y]="";
        }
        
        if(x-1>=0 && y+1<=n && map[x-1][y+1].contains("1")){
            if(!insertBo(x-1,y+1)){
                map[x][y]+="0";
                return false;
            }
        }
        
        if(y+1<=n && map[x][y+1].contains("1")){
            if(!insertBo(x,y+1)){
                map[x][y]+="0";
                return false;
            }
        }
        
        if(y+1<n && map[x][y+1].contains("0")){
            if(!insertStick(x,y+1)){
                map[x][y]+="0";
                return false;
            }
        } 
        return true;
    }
    
    static boolean deleteBo(int x,int y){
        
         if(map[x][y].contains("0")){
            map[x][y]="0";
        }else{
            map[x][y]="";
        }
        
        if(x-1>=0 && map[x-1][y].contains("1")){
            if(!insertBo(x-1,y)){
                map[x][y]+="1";
                return false;
            }
        }
        
        if(x+1 <n && map[x+1][y].contains("1")){
            if(!insertBo(x+1,y)){
                map[x][y]+="1";
                return false;
            }
        }
        
        if(map[x][y].contains("0")){
            if(!insertStick(x,y)){
                map[x][y]+="1";
                return false;
            }
        }
        
        if(x+1<=n && map[x+1][y].contains("0")){
            if(!insertStick(x+1,y)){
                map[x][y]+="1";
                return false;
            }
        } 
        return true;
    }
}