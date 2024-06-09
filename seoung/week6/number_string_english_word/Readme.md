## 숫자 문자열과 영단어

## [link](https://school.programmers.co.kr/learn/courses/30/lessons/81301)


## 문제 풀이

```
import java.util.*;

class Solution {
    public int solution(String s) {
        Map<String, String> map = Map.of(
            "zero", "0",
            "one", "1",
            "two", "2",
            "three", "3",
            "four", "4",
            "five", "5",
            "six", "6",
            "seven", "7",
            "eight", "8",
            "nine", "9"
        );
        
       
        for(String key : map.keySet()){
            s=s.replace(key, map.get(key));
        }
       
        return Integer.parseInt(s); 
    }
}
```