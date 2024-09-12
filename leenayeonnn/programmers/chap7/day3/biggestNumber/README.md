[프로그래머스 - 가장 큰 수](https://school.programmers.co.kr/learn/courses/30/lessons/42746)

---

### 내 풀이
```java
import java.util.Arrays;

class Solution {
    public String solution(int[] numbers) {
        String[] strs = Arrays.stream(numbers)
                .mapToObj(String::valueOf)
                .toArray(String[]::new);

        Arrays.sort(strs, (s1, s2) -> Integer.parseInt(s2 + s1) - Integer.parseInt(s1 + s2));

        if (strs[0].equals("0")) {
            return "0";
        }
        
        StringBuilder sb = new StringBuilder();
        for (String str : strs) {
            sb.append(str);
        }
        return sb.toString();
    }
}
```

<br/>

---

### 교재 풀이

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

