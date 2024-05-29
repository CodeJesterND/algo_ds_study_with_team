# 내 마음대로 정렬하기


## [link](https://school.programmers.co.kr/learn/courses/30/lessons/12915)
```
import java.util.*;

class Solution {
    public String[] solution(String[] strings, int n) {
        
        Arrays.sort(strings , new Comparator<String>() {
            @Override
            public int compare(String o1, String o2){
                if(o1.charAt(n) == o2.charAt(n)) {
                    return o1.compareTo(o2);
                }
                
                return o1.charAt(n) - o2.charAt(n);                        
            }
            
        });
        
        return strings;
    }
}
```