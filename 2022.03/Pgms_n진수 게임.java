class Solution {
    public String solution(int n, int t, int m, int p) {
        String answer = "";
        
        int num=1;
        String str = "00";
        
        while(true){
            int moc=num;
            StringBuilder sb = new StringBuilder();
            
            while(true){
                int nam = moc%n;
                if(nam>=10){
                    sb.append(((char)(nam-10+'A'))+"");
                }else{
                    sb.append(nam);
                }
                moc = moc/n;
                if(moc==0){
                    break;
                }
            }
            str+=sb.reverse();
            if(str.length()>(t-1)*m+p){
                break;
            }
            num++;
        }
        
        for(int i=0;i<t;i++){
            answer+=(str.charAt((m*i)+p)+"");
        }
        
        return answer;
    }
}