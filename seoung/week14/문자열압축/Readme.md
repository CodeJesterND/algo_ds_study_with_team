# [link](https://school.programmers.co.kr/learn/courses/30/lessons/60057)



## 내가 푼 문제풀이

````
class Solution {
    public int solution(String s) {
        int answer = s.length();
        
        
        int result = 1;
        for(int i=1;i<=s.length()/2; i++){
            StringBuilder sb = new StringBuilder();
            String previousStr = s.substring(0, i);
            
            for(int j=i; j <= s.length(); j+=i) {
                int endIdx = Math.min(j + i , s.length());
                String nextStr = s.substring(j, endIdx);
                
                if(previousStr.equals(nextStr)) result++;
                else {
                    if(result >= 2) sb.append(result);
                    sb.append(previousStr);
                    previousStr = nextStr;
                    result =1;
                }
                
            }
            
            sb.append(previousStr);
            answer = Math.min(answer, sb.length());
        }
        
        
        return answer;
    }
}
````

## 책 풀이 
```
import java.util.*;

class Solution {
    
    private List<String> split(String source, int length) {
        List<String> tokens = new ArrayList<>();
        for(int startIndex = 0; startIndex < source.length(); startIndex += length) {
            int endIndex = startIndex + length;
            if(endIndex > source.length()) endIndex = source.length();
            tokens.add(source.substring(startIndex, endIndex));
        }
        
        return tokens;
    }
    
    private int compress(String source, int length) {
        StringBuilder builder = new StringBuilder();
        
        String last = "";
        int count = 0;
        for(String token : split(source, length)) {
            if(token.equals(last)) {
                count++;
            } else {
                if(count > 1) builder.append(count);
                builder.append(last);
                last = token;
                count = 1;
            }
        }
        
        if(count > 1) builder.append(count);
        builder.append(last);
        
        return builder.length();
    }
    
    public int solution(String s) {
        int min = Integer.MAX_VALUE;
        for(int length = 1; length <= s.length(); length++) {
            int compressed = compress(s, length);
            if(compressed < min) min = compressed;
        }
        
        return min;
    }
}
```