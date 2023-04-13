class Solution {
    public String solution(String new_id) {
        
        //1.
        String str = new_id.toLowerCase();
        
        //2.
        String str2 = "";
        for(int i=0;i<str.length();i++){
            char c = str.charAt(i);
            
            if(c=='-' || c=='_' || c=='.' || (c-'a'>=0 && c-'z'<=0) || (c-'0'>=0 && c-'9'<=0)) str2+=c+"";
        }
        
        //3.
        while(true){
            
            if(str2.contains("..")){
                str2=str2.replaceFirst("\\.\\.","\\.");
                continue;
            }
            break;
        }
        
        //4.
        if(str2.charAt(0)=='.') str2 = str2.substring(1,str2.length());
        if(str2.length()>0 && str2.charAt(str2.length()-1)=='.') str2 = str2.substring(0,str2.length()-1);
        
        //5.
        if(str2.equals("")) str2 = "a";
        
        //6.
        if(str2.length()>=16) {
            str2 = str2.substring(0,15);
            if(str2.charAt(str2.length()-1)=='.') str2 = str2.substring(0,str2.length()-1);
        }
        
        //7.
        if(str2.length()==1) {
            str2+=str2.charAt(0)+"";
            str2+=str2.charAt(1)+"";
        }
        if(str2.length()==2) str2+=str2.charAt(1)+"";
        
        return str2;
    }
}
