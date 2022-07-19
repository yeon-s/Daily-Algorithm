class Solution {
    public String solution(String X, String Y) {
        String answer = "";

        int[] arr1 = new int[10];
        int[] arr2 = new int[10];
        for(int i=0;i<X.length();i++){
            int num = X.charAt(i)-'0';
            arr1[num]++;
        }
        for(int i=0;i<Y.length();i++){
            int num = Y.charAt(i)-'0';
            arr2[num]++;
        }

        //짝꿍 없거나 0만 있는거 찾기
        int temp1=0;
        int temp2=0;
        for(int i=0;i<10;i++){
            int num = Math.min(arr1[i],arr2[i]);
            temp1+=num;
            if(i!=0) temp2+=num;
        }
        if(temp1==0) return "-1";
        if(temp2==0) return "0";

        StringBuilder sb = new StringBuilder();
        for(int i=9;i>=0;i--){
            int min = Math.min(arr1[i],arr2[i]);
            for(int j=0;j<min;j++){
                sb.append(i+"");
            }
        }

        return sb+"";
    }
}