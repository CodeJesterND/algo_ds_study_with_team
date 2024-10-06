## 문자열 내림순으로 배치하기

<br/>

### 책 참조 전 상태의 코드
```java
import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public String solution(String s) {
        Character[] chars = new Character[s.length()];
        for (int i = 0; i < s.length(); i++) {
            chars[i] = s.charAt(i);
        }

        Arrays.sort(chars, Comparator.reverseOrder());

        StringBuilder sb = new StringBuilder();
        for (Character c : chars) {
            sb.append(c);
        }

        return sb.toString();
    }
}
```

<br/>

### 책 참조 후 상태의 코드
```java
public class Solution {
    public String solution(String s) {
        return s.chars()
                .boxed()
                .sorted((v1, v2) -> v2 - v1)
                .collect(StringBuilder::new,
                        StringBuilder::appendCodePoint,
                        StringBuilder::append)
                .toString();
    }
}
```