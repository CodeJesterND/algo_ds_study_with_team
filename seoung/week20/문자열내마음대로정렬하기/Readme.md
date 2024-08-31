## 문자열 내마음대로 정렬하기 
### [link](https://school.programmers.co.kr/learn/courses/30/lessons/12915?language=java)


## 내가 푼 문제 풀이
```
import java.util.*;

class Solution {
    public String[] solution(String[] strings, int n) {
        
        Arrays.sort(strings, new Comparator<String>(){
            
            public int compare(String o1, String o2) {
                
                if(o1.charAt(n) == o2.charAt(n)) return o1.compareTo(o2);
                
                return o1.charAt(n) - o2.charAt(n);
            }
        });
        
        return strings;
    }
}
```


- n에서 준 숫자 위치를 string 담아서 넣어주고 Arrays.sort 정렬을 커스텀하여 n의 알파벳이 똑같은 숫자라면 단어가 더빠른것으로 정렬을 그게아니라면 해당 위치 단어를 통해 정렬을 하도록 만들어주었다. 

## 책에서 푼 문제 풀이

```
import java.util.*;

class Solution {
    public String[] solution(String[] strings, int n) {
        
        Arrays.sort(strings, new Comparator<String>(){
            
            public int compare(String o1, String o2) {
                
                if(o1.charAt(n) == o2.charAt(n)) return o1.compareTo(o2);
                
                return o1.charAt(n) - o2.charAt(n);
            }
        });
        
        return strings;
    }
}
```