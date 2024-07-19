## [link](https://school.programmers.co.kr/learn/courses/30/lessons/81301)

## 숫자 문자열과 영단어
# 내 문제 풀이

1. map에 각각 키를 넣어서 해당하는게 있으면 바꿔주는 방식으로 진행하였음.
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

# 책 문제 풀이


```
import java.util.*;

class Solution {
    private static final String[] words = {
      "zero", "one", "two", "three", "four",
      "five", "six", "seven", "eight", "nine",
    };
    public int solution(String s) {
       
        for(int i=0; i < words.length; i++) {
            s = s.replace(words[i], Integer.toString(i));
        }
        
        return Integer.parseInt(s); 
    }
}
```