package practice;

import java.util.*;

class Solution {
    public String solution(String character, String[] monsters) {
        String answer = "";
        
        double[] oneSecondExp = new double[monsters.length];
        
        double max=0;
        
        StringTokenizer st = new StringTokenizer(character);
        int originHp = Integer.parseInt(st.nextToken());
        int power = Integer.parseInt(st.nextToken());
        int guard = Integer.parseInt(st.nextToken());
        
        for(int i=0;i<monsters.length;i++){
            int time=1;
            int hp = originHp;
            st = new StringTokenizer(monsters[i]);
            String name = st.nextToken();
            int exp = Integer.parseInt(st.nextToken());
            int mopHp = Integer.parseInt(st.nextToken());
            int mopPower = Integer.parseInt(st.nextToken());
            int mopGuard = Integer.parseInt(st.nextToken());
            
            boolean flag = false;       //캐릭터가 이길수 있는지 확인
            
            while(true){        //게임시작
                
                if(mopGuard>=power){
                    flag=true;
                    break;
                }
                
                mopHp -=power-mopGuard;
                if(mopHp<=0){
                    break;
                }
                hp -=mopPower-guard;
                if(hp<=0){
                    flag=true;
                    break;
                }
                
                hp=originHp;
                time++;
            }
            
            if(flag){
                oneSecondExp[i]=0;
            }else{
                oneSecondExp[i] = ((double)exp)/((double)time);
                max = Math.max(max,oneSecondExp[i]);
            }
            
        }
        
        //최대값 찾기
        int index=0;
        int maxExp=0;
        for(int i=0;i<monsters.length;i++){
            if(oneSecondExp[i]==max){
                 st = new StringTokenizer(monsters[i]);
                 String name = st.nextToken();
                 int exp = Integer.parseInt(st.nextToken());
                    if(maxExp<exp){
                      answer="";
                        answer = answer+name;
                        maxExp = exp;
                }
            }
        }
        
        return answer;
    }
    
    static void gameStart(){
        
    }
}