import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        int answer = 0;
        
        int size = routes.length;
        boolean[] check = new boolean[size];
        Car[] arr = new Car[size];
        for(int i=0;i<size;i++){
            arr[i] = new Car(routes[i][0],routes[i][1]);
        }
        Arrays.sort(arr,new Comparator<Car>(){
            public int compare(Car o1, Car o2){
                if(o1.start<o2.start){
                    return -1;
                }else{
                    return 1;
                }
            }
        });
        
        for(int i=0;i<size;i++){
            int end = arr[i].end;
            boolean flag=true;      //끝까지 가서 끝나면 true
            for(int j=i+1;j<size;j++){
                if(arr[j].start>end){
                    i=j-1;
                    answer++;
                    flag=false;
                    break;
                }else{
                    if(arr[j].end<end){
                        end=arr[j].end;
                    }
                }
            }
            if(flag){
                answer++;
                break;
            }
        }
        return answer;
    }
    
    
    static class Car{
        int start;
        int end;
        public Car(int start,int end){
            this.start=start;
            this.end=end;
        }
    }
}