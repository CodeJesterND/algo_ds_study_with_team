## 문자열 내 마음대로 정렬하기

<br/>

### 책 참조 전 상태의 코드
```java
import java.util.Arrays;

public class Solution {
    public String[] solution(String[] strings, int n) {
        Arrays.sort(strings, (s1, s2) -> {
            char c1 = s1.charAt(n); 
            char c2 = s2.charAt(n); 

            if (c1 == c2) {
                return s1.compareTo(s2);
            } else {
                return Character.compare(c1, c2);
            }
        });
        return strings;
    }
}
```

<br/>

### 책 참조 후 상태의 코드
```java
import java.util.Arrays;

public class Solution {
    public String[] solution(String[] strings, int n) {
        Arrays.sort(String, (s1, s2) -> {
            if (s1.charAt(n) != s2.charAt(n)) {
                return s1.charAt(n) - s2.charAt(n);
            }
            return s1.compareTo(s2);
        });
        return strings;
    }
}
```