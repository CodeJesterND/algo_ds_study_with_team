## 가장 큰 수

<br/>

### 책 참조 전 상태의 코드
```java
import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public String solution(int[] numbers) {
        return Arrays.stream(numbers)
            .mapToObj(String::valueOf)  // 숫자를 문자열로 변환
            .sorted((s1, s2) -> (s2 + s1).compareTo(s1 + s2))  // 문자열 비교로 큰 수가 앞에 오도록 정렬
            .collect(Collectors.joining(""))  // 모든 문자열을 이어붙임
            .replaceAll("^0+", "0");  // "000..."은 "0"으로 변환
    }
}
```

<br/>

### 책 참조 후 상태의 코드
```java
import java.util.Arrays;
import java.util.stream.Collectors;

public class Solution {
    public String solution(int[] numbers) {
        return Arrays.stream(numbers) 
                .mapToObj(String::valueOf)
                .sorted((s1, s2) -> {
                    int original = Integer.parseInt(s1 + s2);
                    int reversed = Integer.parseInt(s2 + s1);
                    return reversed - original;
                })
                .collect(Collectors.joining(""))
                .replaceAll("^0+", "0");
    }
}
```