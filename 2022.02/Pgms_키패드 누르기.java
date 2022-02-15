class Solution {
    public String solution(int[] numbers, String hand) {
        String answer = "";
        
        int size = numbers.length;
        
        Point[] arr = new Point[size];
        int[] curR = new int[2];
        curR[0]=3;
        curR[1]=2;
        int[] curL = new int[2];
        curL[0]=3;
        curL[1]=0;
        
        for(int i=0;i<size;i++){
            switch(numbers[i]){
                case 0: arr[i]=new Point(3,1);
                    break;
                case 1: arr[i]=new Point(0,0);
                    break;
                case 2: arr[i]=new Point(0,1);
                    break;
                case 3: arr[i]=new Point(0,2);
                    break;
                case 4: arr[i]=new Point(1,0);
                    break;
                case 5: arr[i]=new Point(1,1);
                    break;
                case 6: arr[i]=new Point(1,2);
                    break;
                case 7: arr[i]=new Point(2,0);
                    break;
                case 8: arr[i]=new Point(2,1);
                    break;
                case 9: arr[i]=new Point(2,2);
                    break;
            }    
        }
        
        StringBuilder sb = new StringBuilder();
        
        for(int i=0;i<size;i++){
            int num = numbers[i];
            int gi = arr[i].i;
            int gj = arr[i].j;
            if(num==1 || num==4 || num==7){
                sb.append("L");
                curL[0] = arr[i].i;
                curL[1] = arr[i].j;
            }else if(num==3 || num==6 || num==9){
                sb.append("R");
                curR[0] = arr[i].i;
                curR[1] = arr[i].j;
            }else{
                int distanceR = Math.abs(curR[0]-gi)+Math.abs(curR[1]-gj);
                int distanceL = Math.abs(curL[0]-gi)+Math.abs(curL[1]-gj);
                
                if((distanceR>distanceL) || (distanceR==distanceL && hand.equals("left")) ){
                    sb.append("L");
                    curL[0]=gi;
                    curL[1]=gj;
                }else if( (distanceR<distanceL) || (distanceR==distanceL && hand.equals("right")) ){
                    sb.append("R");
                    curR[0]=gi;
                    curR[1]=gj;
                }   
            }
        }
        
        answer = (sb+"");
        
        return answer;
    }
    
    static class Point{
        int i;
        int j;
        public Point(int i,int j){
            this.i=i;
            this.j=j;
        }
    }
}