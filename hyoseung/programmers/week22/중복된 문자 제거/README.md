## 중복된 문자 제거

<br/>

### 책 참조 전 상태의 코드
```java
import java.util.LinkedHashSet;
import java.util.Set;

class Solution {
    public String solution(String my_string) {
        Set<Character> set = new LinkedHashSet<>();
        
        for (char ch : my_string.toCharArray()) {
            set.add(ch);
        }
        
        StringBuilder result = new StringBuilder();
        for (char ch : set) {
            result.append(ch);
        }
        
        return result.toString();
    }
}
```

<br/>

### 책 참조 후 상태의 코드
```java
import java.util.HashSet;
import java.util.Set;

public class Solution {
    public String solution(String myString) {
        Set<Character> used = new HashSet<>();
        
        StringBuilder builder = new StringBuilder();
        for(char c : myString.toCharArray()) {
            if (used.contains(c)) continue;
            used.add(c);
            builder.append(c);
        }
        
        return builder.toString();
    }
}
```