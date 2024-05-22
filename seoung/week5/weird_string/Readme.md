# 이상한 문자 만들기 


````
class Solution {
    public String solution(String s) {
       
        // "try hello world"  
        // "TrY HeLIO WoRID" 
        String [] answer = s.split(" ",-1);
        
        StringBuffer sb = new StringBuffer();
        
        for(int i=0;i < answer.length;i++){
            for(int j=0;j < answer[i].length(); j++){
                if(j%2!=0) {
                    sb.append(Character.toLowerCase(answer[i].charAt(j)));
                } else{
                   sb.append(Character.toUpperCase(answer[i].charAt(j)));
                }
            }
          if(i!=answer.length-1)sb.append(" ");
        }
        
        return sb.toString();
    }
}
````