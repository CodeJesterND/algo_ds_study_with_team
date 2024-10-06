## A로 B 만들기

<br/>

### 책 참조 전 상태의 코드
```java
import java.util.Arrays;

class Solution {
    public int solution(String before, String after) {
        char[] beforeArray = before.toCharArray();
        char[] afterArray = after.toCharArray();

        Arrays.sort(beforeArray);
        Arrays.sort(afterArray);

        return Arrays.equals(beforeArray, afterArray) ? 1 : 0;
    }
}
```

<br/>

### 책 참조 후 상태의 코드
```java
import java.util.HashMap;
import java.util.Map;

public class Solution {
    private static Map<Character, Integer> toMap(String word) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : word.toCharArray()) {
            map.putIfAbsent(c, 0);
            map.put(c, map.get(c) + 1);
        }
        return map;
    }
    
    public int solution(String before, String after) {
        return toMap(before).equals(toMap(after)) ? 1 : 0;
    }
}
```