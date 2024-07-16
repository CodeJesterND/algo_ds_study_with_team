# [link](https://school.programmers.co.kr/learn/courses/30/lessons/12930)

## 문제풀이


```
class Solution {
    public String solution(String s) {
       
        // "try hello world"  
        // "TrY HeLIO WoRID" 
        StringBuilder answer = new StringBuilder();
        
        String []str = s.split(" ",-1);
        int index = 0;
        boolean lastFlag = false;
        for(String w : str) {
            for(int i=0; i<w.length(); i++){
                answer.append(makeString(i, String.valueOf(w.charAt(i))));
            }
            index++;
            if(index == str.length) lastFlag = true;
            if(!lastFlag) answer.append(" ");
        }
        
        return answer.toString();
    }
    
    private String makeString(int index, String ch) {
         if(index%2==0) ch = ch.toUpperCase();
         else if(index%2==1) ch = ch.toLowerCase();
         
        return ch;
    }
}
```


## 책 문풀
```
class Solution {
    public String solution(String s) {
       
        // "try hello world"  
        // "TrY HeLIO WoRID" 
        StringBuilder builder = new StringBuilder();
        boolean toUpper = true;
        
        
        for(char c : s.toCharArray()) {
            if(!Character.isAlphabetic(c)) {
                builder.append(c);
                toUpper = true;
            } else {
                if(toUpper) {
                    builder.append(Character.toUpperCase(c));
                } else {
                    builder.append(Character.toLowerCase(c));
                }
                toUpper = !toUpper;
            }
        }
        
        return builder.toString();
    }
 
}
```

