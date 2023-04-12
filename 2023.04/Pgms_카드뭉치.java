class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        String answer = "Yes";
        
        int size1 = cards1.length;
        int size2 = cards2.length;
        int index1=0;
        int index2=0;
        
        for(int i=0;i<goal.length;i++){
            String str = goal[i];
            
            if(str.equals(cards1[index1])){
                index1 = (index1<size1-1) ? index1+1 : index1;
            }else if(str.equals(cards2[index2])){
                index2 = (index2<size2-1) ? index2+1 : index2;
            }else{
                return "No";
            }
            
        }
    
        return answer;
    }
}
